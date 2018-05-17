package com.learning.graphql.graphqlSpringService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.SchemaParser;
import com.coxautodev.graphql.tools.SchemaParserBuilder;
import com.learning.graphql.graphqlSpringService.resolver.GreetingMutation;
import com.learning.graphql.graphqlSpringService.resolver.GreetingQuery;
import com.learning.graphql.graphqlSpringService.resolver.Mutation;
import com.learning.graphql.graphqlSpringService.resolver.Query;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;


@Component
public class GraphQlHandler {

	
	private static final String SCHEMA_LOOKUP = "./graphql/";
	

	private static GraphQLSchema executableSchema;
    private static final String[] SCHEMA_FILES = new String[] {
				"greeting.graphqls",
				"book.graphqls",
				"author.graphqls",
				"category.graphqls"};
	
	
	@Autowired
	private GreetingQuery queryResolver;
	@Autowired
	private GreetingMutation mutationResolver;
	
	@Autowired
	private Query query;
	@Autowired
	private Mutation mutation;
	  
	  
  


  @PostConstruct
  private void init() {
    SchemaParserBuilder parser = SchemaParser.newParser();

    parser.files(getSchemaFilePaths());
    parser.resolvers(queryResolver, mutationResolver, query, mutation);
    

    executableSchema = parser.build().makeExecutableSchema();
  }

  

	/**
	 *
	 * @param data
	 * @return
	 */
	public GraphQL query() {
		return GraphQL.newGraphQL(executableSchema).build();
	}
	
	/**
	 *
	 * @return
	 */
	private String[] getSchemaFilePaths() {
		List<String> response = new ArrayList<>();

		String rootPath = SCHEMA_LOOKUP;

		for (String file : SCHEMA_FILES) {
			boolean found = (null != getClass().getClassLoader().getResourceAsStream(rootPath + file));

			if (found) {
				response.add(rootPath + file);
			}
		}

		if (response.isEmpty()) {
			throw new IllegalStateException(String.format("There was no valid schema-file for lookup-path %s found.", rootPath));
		}

		return response.toArray(new String[response.size()]);
	}

}
