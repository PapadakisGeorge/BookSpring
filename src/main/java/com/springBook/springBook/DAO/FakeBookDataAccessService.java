package com.springBook.springBook.DAO;


import com.springBook.springBook.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeBookDataAccessService implements BookDao {

    private static final List<Book> database = new ArrayList<>();

    @Override
    public int insertBook(UUID id, Book book) {
        database.add(new Book(id, book.getBookName()));
        return 1;
    }

    @Override
    public List<Book> showAllBooks() {
        return database;
    }

    @Override
    public Optional<Book> selectBookByID(UUID bookID) {
        return database.stream()
                .filter(book -> book.getBookID().equals(bookID))
                .findFirst();
    }

    @Override
    public int deleteBookByID(UUID bookID) {
        Optional<Book> possibleBook = selectBookByID(bookID);
        if (possibleBook.isEmpty()) {
            return 0;
        } else {
            database.remove(possibleBook.get());
            return 1;
        }
    }

    @Override
    public int updateBookByID(UUID bookID, Book updatedBook) {
        return selectBookByID(bookID).map(book -> {
            int indexOfBookToUpdate = database.indexOf(book);
            if (indexOfBookToUpdate >= 0) {
                database.set(indexOfBookToUpdate, new Book(bookID, updatedBook.getBookName()));
                return 1;
            } else {
                return 0;
            }
        }).orElse(0);
    }
}
