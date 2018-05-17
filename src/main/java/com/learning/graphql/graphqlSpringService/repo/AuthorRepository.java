package com.learning.graphql.graphqlSpringService.repo;

import org.springframework.data.repository.CrudRepository;

import com.learning.graphql.graphqlSpringService.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
