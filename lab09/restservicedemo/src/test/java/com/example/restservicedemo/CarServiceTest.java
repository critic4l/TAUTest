package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.ResponseSpecification;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.jayway.restassured.RestAssured;

public class CarServiceTest {
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}
	
	@Test
	public void getAllCars() {
		String cars = get("/car/all/").asString();
		
		assertNotNull(cars);
	}
	
	@Test
	public void clearCars() {
		delete("/car/").then().assertThat().statusCode(200);
		
		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(Car.class).
	    when().
	    then().
	    body("", Matchers.hasSize(0));
		
	}
	
	@Test
	public void addCars(){		
		
		delete("/car/").then().assertThat().statusCode(200);
		
		Car car = new Car(1L, "Mazda", "6", 2008);
		
		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(car).
	    when().	     
	    post("/car/").then().assertThat().statusCode(201);
				
		Car rCar = get("/car/1").as(Car.class);
		
		assertThat("6", equalToIgnoringCase(rCar.getModel()));
		
	}
}
