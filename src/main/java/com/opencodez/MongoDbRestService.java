package com.opencodez;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.opencodez.domain.Users;
import com.opencodez.repo.UserRepository;


@Path("/MonogoDbConnection")
public class MongoDbRestService {
	@Autowired
	UserRepository repository;
	Users users = new Users();
	
	public  void method() {
		//deleteAll();
		//addSampleData();
		listAll();
		
		findByRegex();
	
	 }
	@POST
	@Consumes("application/json")
	public Response addSampleData() {
		System.out.println("Adding sample data");
		repository.save(new Users("Guru kathir", "New York", 11111d,"Moni"));
		repository.save(new Users("Harvey Spectre", "Lon", 22222d,"Mon0"));
		repository.save(new Users("Mike Ross", "New Jersey", 333333d,"Mon2"));
		repository.save(new Users("Louise Litt", "Kathmandu", 44444d,"guru"));
		return Response.status(201).build();
	}
	@DELETE
	@Path("/{name}")
	@Consumes("application/json")
	public Response deleteAll(@PathParam("name") String name) {
		System.out.println("Deleting all records..");
		Users u = repository.findFirstByName(name);
		//u.setLastname("Baby");
		//repository.save(u);
		repository.delete(u);
		return Response.status(200).build();
	}
	@PUT
	@Path("/{name}")
	@Consumes("application/json")
	public Response addSampleData(@PathParam("name") String name) {
		System.out.println("Adding sample data");
		String firstname;
		  firstname=name;
		  System.out.println("firstname" +firstname);
		System.out.println("Finding first by Name");
		//repository.findById(firstname);
		Users u = repository.findFirstByName(firstname);
		u.setLastname("Baby");
		repository.save(u);
		//repository.save(new Users("Mike Ross1", "New York", 11111d,"Moni"));
		//repository.save(new Users("Harvey Spectre", "Lon", 22222d,"Mon0"));
		//repository.save(new Users("Mike Ross", "New Jersey", 333333d,"Mon2"));
		//repository.save(new Users("Louise Litt", "Kathmandu", 44444d,"Min1"));
		return Response.status(201).build();
	}
	
	@GET
	@Produces("application/json")
	public Response listAll() {
		System.out.println("Listing sample data");
		List<Users> userList = new ArrayList<Users>();
		repository.findAll().forEach(u -> 
		userList.add(u)
		);		
		return Response.status(200).build();
	}
	
	  @GET
	  @Path("/{name}")
	  @Produces("application/json")
	public Response getDetails( @PathParam("name") String name){
		 
		  String firstname;
		  firstname=name;
		  System.out.println("firstname" +firstname);
		System.out.println("Finding first by Name");
		//repository.findById(firstname);
		Users u = repository.findFirstByName(firstname);
		users.setName(u.getName());
		System.out.println(users.getName());
		System.out.println(u.getLastname().toString());
		return Response.status(200).entity(u).build();
	}
	
	public void findByRegex() {
		System.out.println("Finding by Regex - All with address starting with ^New");
		repository.findCustomByRegExAddress("^New").forEach(u -> System.out.println(u));
	}
}
