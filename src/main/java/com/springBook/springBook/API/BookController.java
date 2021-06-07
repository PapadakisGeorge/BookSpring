package com.springBook.springBook.API;

import com.springBook.springBook.model.Book;
import com.springBook.springBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("API/v1/book")
@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    private BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public void insertBook(@RequestBody @NonNull Book book){
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{bookID}")
    public Book getBookByID(@PathVariable("bookID") UUID bookID) {
        return bookService.getBookByID(bookID)
                .orElse(null);
    }

    @DeleteMapping(path = "{bookID}")
    public void deleteBookByID(@PathVariable("bookID") UUID bookID){
        bookService.deleteBook(bookID);
    }

    @PutMapping(path = "{bookID}")
    public void updateBookByID(@PathVariable("bookID") UUID bookID, @RequestBody @NonNull Book book){
        bookService.updateBook(bookID, book);
    }
}
