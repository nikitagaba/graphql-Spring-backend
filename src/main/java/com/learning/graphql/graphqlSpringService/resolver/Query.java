package com.learning.graphql.graphqlSpringService.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.learning.graphql.graphqlSpringService.model.Author;
import com.learning.graphql.graphqlSpringService.model.Book;
import com.learning.graphql.graphqlSpringService.model.BookCategory;
import com.learning.graphql.graphqlSpringService.repo.AuthorRepository;
import com.learning.graphql.graphqlSpringService.repo.BookCategoryRepository;
import com.learning.graphql.graphqlSpringService.repo.BookRepository;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private BookCategoryRepository bookCategoryRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
    
    public Iterable<BookCategory> findAllCategory(){
    	return bookCategoryRepository.findAll();
    }
}