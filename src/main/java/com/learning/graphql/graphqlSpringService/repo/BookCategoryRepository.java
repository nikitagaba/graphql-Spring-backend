package com.learning.graphql.graphqlSpringService.repo;

import org.springframework.data.repository.CrudRepository;

import com.learning.graphql.graphqlSpringService.model.BookCategory;

public interface BookCategoryRepository extends CrudRepository<BookCategory, Long>{

}
