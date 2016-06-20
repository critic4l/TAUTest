package com.example.restservicedemo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.PersonManager;

@Path("cars")
public class CarFakeRESTService {	
	
	private PersonManager pm = new PersonManager();
	
	@GET
	@Path("/{carId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car getCar(@PathParam("carId") Long id){
		Car c = pm.getCar(id);
		return c;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCar(Car car) {
		
		pm.addCar(car);
		return Response.status(201).entity("Car").build(); 
	}
	
	@POST
    @Path("/sell/{carId}/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sellWeapon(@PathParam("carId") long c_id,
                               @PathParam("personId") long p_id)
    {
        Car car = pm.getCar(c_id);
        Person person = pm.getPerson(p_id);
        pm.sellCar(car, person);
        return Response.status(201).entity("Weapon").build();
    }
	
	@DELETE
	public Response clearCars(){
		pm.clearCars();
		return Response.status(200).build();
	}

}
