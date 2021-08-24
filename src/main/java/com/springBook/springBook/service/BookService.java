package com.springBook.springBook.service;

import com.springBook.springBook.models.Book;
import com.springBook.springBook.repositories.BookRepository;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long bookID) {
        boolean exists = bookRepository.existsById(bookID);
        if (!exists){
            throw new IllegalStateException("Book with ID " + bookID + " does not exists");
        } else {
            bookRepository.deleteById(bookID);
        }
    }

    @Transactional
    public void updateBook(Long bookID, String bookName, String bookAuthor, String bookEdition, Integer bookPublicationDate) {

        Book book = bookRepository.findById(bookID)
               .orElseThrow(() -> new IllegalStateException(
                       "Book with ID " + bookID + " does not exists"
               ));
       if (bookName != null &&
               bookName.length() > 0 &&
               !Objects.equals(book.getBookName(), bookName)) {
           book.setBookName(bookName);
       }
        if (bookAuthor != null &&
                bookAuthor.length() > 0 &&
                !Objects.equals(book.getBookAuthor(), bookAuthor)) {
            book.setBookAuthor(bookAuthor);
        }
        if (bookEdition != null &&
                bookEdition.length() > 0 &&
                !Objects.equals(book.getBookEdition(), bookEdition)) {
            book.setBookEdition(bookEdition);
        }
        if (bookPublicationDate != null &&
                !Objects.equals(book.getBookPublicationDate(), bookPublicationDate)) {
            book.setBookPublicationDate(bookPublicationDate);
        }
    }
}


