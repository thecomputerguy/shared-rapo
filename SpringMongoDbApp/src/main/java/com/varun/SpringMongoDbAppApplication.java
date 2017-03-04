package com.varun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringMongoDbAppApplication {

	@Autowired
	MongoOperations mongo;
	@Autowired
	SpringRepositoryMongo springRepositoryMongo;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoDbAppApplication.class, args);
	}

	@RequestMapping(value = {"/get/{id}"}, method = RequestMethod.GET, produces = "application/json")
	public List<Person> getStudent(@PathVariable("id") String _id){
		Person p = springRepositoryMongo.findOne(_id);
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("varun"));
		List<Person> p1 = mongo.find(query,Person.class);
		return p1;
	}

	@RequestMapping(value = {"/getAll"}, method = RequestMethod.GET, produces = "application/json")
	public List<Person> getStudents(){
		return mongo.findAll(Person.class);
	}

	@RequestMapping(value = {"/create"}, method = RequestMethod.POST, produces = "application/json")
	public Person createStudent(@RequestBody Person p){
		Person per = springRepositoryMongo.save(p);
		return per;
	}
}
