package com.learning.graphql.graphqlSpringService.repo;

import org.springframework.data.repository.CrudRepository;

import com.learning.graphql.graphqlSpringService.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
