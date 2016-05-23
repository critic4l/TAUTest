package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.parsing.Parser;

public class PersonServiceTest {
	
	private static final String PERSON_FIRST_NAME = "Jasiu";
	
	@BeforeClass
    public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";  
		RestAssured.defaultParser = Parser.JSON;
    }
	
	@Test
	public void getAllPersons() {
		String persons = get("/person/all").asString();
		assertNotNull(persons);		
	}
	
	@Test
	public void clearPersons() {
		delete("/person/").then().assertThat().statusCode(200);
		
		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(Person.class).
	    when().
	    then().
	    body("", Matchers.hasSize(0));
		
	}
	
	@Test
	public void addPersons(){		
		
		delete("/person/").then().assertThat().statusCode(200);
		
		Person person = new Person(1L, PERSON_FIRST_NAME, 1976);
		
		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(person).
	    when().	     
	    post("/person/").then().assertThat().statusCode(201);
				
		Person rPerson = get("/person/1").as(Person.class);
		
		assertThat(PERSON_FIRST_NAME, equalToIgnoringCase(rPerson.getFirstName()));
		
	}
	

}
