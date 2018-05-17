package com.learning.graphql.graphqlSpringService.model;



public class Greeting implements java.io.Serializable{

	  private String id;

	  private String message;

	  public Greeting() {}

	  public Greeting(String id, String message) {
	    this.id = id;
	    this.message = message;
	  }

	  public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }
}