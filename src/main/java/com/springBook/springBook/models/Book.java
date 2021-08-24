package com.springBook.springBook.models;

import javax.persistence.*;

@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long bookID;
    private String bookName;
    private String bookAuthor;
    private String bookEdition;
    private Integer bookPublicationDate;

    public Book() {
    }

    public Book(Long bookID,
                String bookName,
                String bookAuthor,
                String bookEdition,
                Integer bookPublicationDate) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookEdition = bookEdition;
        this.bookPublicationDate = bookPublicationDate;
    }

    public Book(String bookName,
                String bookAuthor,
                String bookEdition,
                Integer bookPublicationDate) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookEdition = bookEdition;
        this.bookPublicationDate = bookPublicationDate;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }


    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public Integer getBookPublicationDate() {
        return bookPublicationDate;
    }

    public void setBookPublicationDate(Integer bookPublicationDate) {
        this.bookPublicationDate = bookPublicationDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookEdition='" + bookEdition + '\'' +
                ", bookPublicationDate=" + bookPublicationDate +
                '}';
    }
}
