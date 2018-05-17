package com.learning.graphql.graphqlSpringService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;

import graphql.ExecutionResult;
import graphql.GraphQL;

@RestController
public class MainController {

	@Autowired
	private GraphQlHandler graphQL;

	
	@PostMapping(value = "/graphql")
	  public ResponseEntity<String> index(@RequestBody String body) {
	    GraphQL graph = graphQL.query();
	    ExecutionResult result = graph.execute(body);
	    return new ResponseEntity<>(enrichResult(result), HttpStatus.OK);
	  }
	
	 /**
	   * @param result
	   * @return
	   */
	  private String enrichResult(ExecutionResult result) {
	    return new GsonBuilder()
	      .setPrettyPrinting()
	      .serializeNulls()
	      .create()
	      .toJson(result.toSpecification());
	  }
}
