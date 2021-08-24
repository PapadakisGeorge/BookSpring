package com.springBook.springBook.api;

import com.springBook.springBook.models.Book;
import com.springBook.springBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping
    public void registerNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookID}")
    public void deleteBook(@PathVariable("bookID") Long bookID){
        bookService.deleteBook(bookID);
    }

    @PutMapping(path = "{bookID}")
    public void updateBook(
            @PathVariable("bookID") Long bookID,
            @RequestParam(required = false) String bookName,
            @RequestParam(required = false) String bookAuthor,
            @RequestParam(required = false) String bookEdition,
            @RequestParam(required = false) Integer bookPublicationDate
    ){
        bookService.updateBook(bookID, bookName, bookAuthor, bookEdition, bookPublicationDate);
    }
}
