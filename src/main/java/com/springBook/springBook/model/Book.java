package com.springBook.springBook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Book {

    private final UUID bookID;

    private final String bookName;

    public Book(
            @JsonProperty("bookID") UUID bookID,
            @JsonProperty("bookName") String bookName
    ) {
        this.bookID = bookID;
        this.bookName = bookName;
    }

    public UUID getBookID() {
        return bookID;
    }
    public String getBookName() {
        return bookName;
    }

}
