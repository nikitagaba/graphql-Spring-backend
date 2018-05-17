package com.learning.graphql.graphqlSpringService.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.learning.graphql.graphqlSpringService.model.Greeting;


@Component
public class GreetingRepository {

	public GreetingRepository(){
		greetings = new HashMap<>();
	}
	private Map<String, Greeting> greetings;
	
	
	/**
	 * @param id
	 * @return
	 */
	public Greeting find(String id) {
		return greetings.get(id);
	}
	
	/**
	 * @param greeting
	 * @return
	 */
	public Greeting save(Greeting greeting){
		String id = Integer.valueOf(greetings.size()+1).toString();
		greetings.put(id, greeting);
		
		greeting.setId(id);
		return greeting;	}

}
