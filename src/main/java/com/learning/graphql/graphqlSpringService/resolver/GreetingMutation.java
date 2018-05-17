package com.learning.graphql.graphqlSpringService.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.learning.graphql.graphqlSpringService.model.Greeting;
import com.learning.graphql.graphqlSpringService.repo.GreetingRepository;

@Component
public class GreetingMutation implements GraphQLMutationResolver {

	@Autowired
	private GreetingRepository greetingRepository;
	
	
	/**
	 * @param message
	 * @return
	 */
	public Greeting newGreeting(String message){
		Greeting greeting = new Greeting();
	    greeting.setMessage(message);
		return greetingRepository.save(greeting);
	}
}
