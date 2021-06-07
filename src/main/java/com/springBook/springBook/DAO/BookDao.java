package com.springBook.springBook.DAO;

import com.springBook.springBook.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {

    int insertBook(UUID id, Book book);

    default int insertBook(Book book){
        UUID id = UUID.randomUUID();
        return insertBook(id, book);
    }

    List<Book> showAllBooks();

    Optional<Book> selectBookByID(UUID bookID);

    int deleteBookByID(UUID bookID);

    int updateBookByID(UUID bookID, Book book);

}
