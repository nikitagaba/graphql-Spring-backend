package com.learning.graphql.graphqlSpringService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learning.graphql.graphqlSpringService.model.Author;
import com.learning.graphql.graphqlSpringService.model.Book;
import com.learning.graphql.graphqlSpringService.model.BookCategory;
import com.learning.graphql.graphqlSpringService.repo.AuthorRepository;
import com.learning.graphql.graphqlSpringService.repo.BookCategoryRepository;
import com.learning.graphql.graphqlSpringService.repo.BookRepository;
import com.learning.graphql.graphqlSpringService.repo.GreetingRepository;
import com.learning.graphql.graphqlSpringService.resolver.BookResolver;
import com.learning.graphql.graphqlSpringService.resolver.Mutation;
import com.learning.graphql.graphqlSpringService.resolver.Query;

@SpringBootApplication
public class GraphServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphServiceApplication.class, args);
	}
		
		@Bean
		public BookResolver authorResolver(AuthorRepository authorRepository, BookCategoryRepository bookCategoryRepository) {
			return new BookResolver(authorRepository, bookCategoryRepository);
		}

		@Bean
		public Query query(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
			return new Query(authorRepository, bookRepository, bookCategoryRepository);
		}

		@Bean
		public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository){
			return new Mutation(authorRepository, bookRepository,bookCategoryRepository);
		}
		
		 @Bean
			public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
				return (args) -> {
					Author author = new Author("Nikita", "Gaba");
					authorRepository.save(author);
					
					BookCategory category = new BookCategory();
					category.setName("Java");
					bookCategoryRepository.save(category);

					bookRepository.save(new Book("Graphql with Spring Boot 2.X", "00323233", 728, author, category));
				};
			}
	
}
