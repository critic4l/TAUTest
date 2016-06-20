package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.core.MediaType;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.jayway.restassured.RestAssured;

public class CarFakeRESTServiceTest {
	
	private static IDatabaseConnection connection;
	private static IDatabaseTester databaseTester;
	
	@BeforeClass
	public static void setUp() throws Exception{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
		
		Connection jdbcConnection;
		jdbcConnection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		connection = new DatabaseConnection(jdbcConnection);
		
		databaseTester = new JdbcDatabaseTester(
				"org.hsqldb.jdbcDriver", "jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(
				new FileInputStream(new File("src/test/resources/fullData.xml")));
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}
	
	@Test
	public void addCar() throws Exception {
		Car aCar = new Car(2, "Opel", 2011);
		given().contentType(MediaType.APPLICATION_JSON).body(aCar)
				.when().post("/cars/").then().assertThat().statusCode(201);

		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("CAR");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"OWNER_ID", "C_ID"});
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/carData.xml"));
		ITable expectedTable = expectedDataSet.getTable("CAR");
		
		Assertion.assertEquals(expectedTable, filteredTable);
	}
	
	@Test
	public void getAllCars() throws Exception {
		
		IDataSet dbDataSet = connection.createDataSet();
		ITable table = dbDataSet.getTable("PERSON");
		
		assertNotNull(table);
	}
	
	@Test
	public void clearPersons() throws Exception {
		
		IDataSet dbDataSet = connection.createDataSet();
		ITable table = dbDataSet.getTable("PERSON");
		
		assertNotNull(table);
		
		delete("/cars/").then().assertThat().statusCode(200);
			
	}
	
	@AfterClass
	public static void tearDown() throws Exception{
		databaseTester.onTearDown();
	}
}
