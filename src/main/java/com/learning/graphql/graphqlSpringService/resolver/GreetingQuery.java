package com.learning.graphql.graphqlSpringService.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.learning.graphql.graphqlSpringService.model.Greeting;
import com.learning.graphql.graphqlSpringService.repo.GreetingRepository;

@Component
public class GreetingQuery implements GraphQLQueryResolver{
	
	@Autowired
	private GreetingRepository greetingRepository;
	
	public Greeting getGreeting(String id){
		return greetingRepository.find(id);
	}

}
