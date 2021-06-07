package com.springBook.springBook.DAO;

import com.springBook.springBook.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BookDataAccessService implements BookDao{
    @Override
    public int insertBook(UUID id, Book book) {
        return 0;
    }

    @Override
    public List<Book> showAllBooks() {
        return List.of(new Book(UUID.randomUUID(), "FROM POSTGRES DATABASE"));
    }

    @Override
    public Optional<Book> selectBookByID(UUID bookID) {
        return Optional.empty();
    }

    @Override
    public int deleteBookByID(UUID bookID) {
        return 0;
    }

    @Override
    public int updateBookByID(UUID bookID, Book book) {
        return 0;
    }
}
