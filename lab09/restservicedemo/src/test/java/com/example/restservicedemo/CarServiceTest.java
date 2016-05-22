package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

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
