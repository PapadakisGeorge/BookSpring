package com.springBook.springBook.service;

import com.springBook.springBook.DAO.BookDao;
import com.springBook.springBook.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("fakeDao") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int addBook(Book book) {
        return bookDao.insertBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.showAllBooks();
    }

    public Optional<Book> getBookByID(UUID bookID) {
        return bookDao.selectBookByID(bookID);
    }

    public int deleteBook(UUID bookID) {
        return bookDao.deleteBookByID(bookID);
    }

    public int updateBook(UUID bookID, Book book) {
        return bookDao.updateBookByID(bookID, book);
    }

}
