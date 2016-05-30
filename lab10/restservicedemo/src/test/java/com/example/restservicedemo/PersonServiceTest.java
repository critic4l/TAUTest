package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.jayway.restassured.RestAssured;

public class PersonServiceTest {
	
	private static final String PERSON_FIRST_NAME = "Jasiu";
	private static final String CAR_MODEL = "Corsa";
	
	@BeforeClass
    public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";   	
    }
	
	@Test
	public void addPersons(){		
		
		delete("/person/").then().assertThat().statusCode(200);
		
		Person person = new Person(PERSON_FIRST_NAME, 1976);
		
		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(person).
	    when().	     
	    post("/person/").then().assertThat().statusCode(201);
				
		Person rPerson = get("/person/0").as(Person.class);
		
		assertThat(PERSON_FIRST_NAME, equalToIgnoringCase(rPerson.getFirstName()));
		
	}
	
	//no nie... to nie działa :/
	@Test
	public void addCars() {
		
		delete("/person/").then().assertThat().statusCode(200);
		
		Car car = new Car(CAR_MODEL, 1996);
		given().
			contentType(MediaType.APPLICATION_JSON).
			body(car).
			when().	     
		post("/person/car").then().assertThat().statusCode(201);
		
		Car rCar = get("/person/car/0").as(Car.class);
				
		assertThat(CAR_MODEL, equalToIgnoringCase(rCar.getModel()));
	}
}
