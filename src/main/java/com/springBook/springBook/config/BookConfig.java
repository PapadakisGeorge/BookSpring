package com.springBook.springBook.config;

import com.springBook.springBook.models.Book;
import com.springBook.springBook.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository){
        return args -> {
            Book nineteenEightyFour = new Book(
                    "1984",
                    "George Orwell",
                    "1st",
                    1984
            );

            Book theCastle = new Book(
                    "The Castle",
                    "Franz Kafka",
                    "1st",
                    1926
            );
            bookRepository.saveAll(List.of(nineteenEightyFour, theCastle));
        };
    }
}
