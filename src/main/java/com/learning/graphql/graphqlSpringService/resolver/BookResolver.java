package com.learning.graphql.graphqlSpringService.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.learning.graphql.graphqlSpringService.model.Author;
import com.learning.graphql.graphqlSpringService.model.Book;
import com.learning.graphql.graphqlSpringService.model.BookCategory;
import com.learning.graphql.graphqlSpringService.repo.AuthorRepository;
import com.learning.graphql.graphqlSpringService.repo.BookCategoryRepository;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;
    private BookCategoryRepository bookCategoryRepository;

    public BookResolver(AuthorRepository authorRepository, BookCategoryRepository bookCategoryRepository) {
        this.authorRepository = authorRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).get();
    }
    
    public BookCategory getBookCategory(Book book) {
        return bookCategoryRepository.findById(Long.valueOf(Integer.valueOf(book.getBookCategory().getId()).toString())).get();
    }
}