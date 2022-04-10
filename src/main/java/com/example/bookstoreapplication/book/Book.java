package com.example.bookstoreapplication.book;


public class Book {

    private final Integer bookId;
    private final String bookName;

    public Book(Integer bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public Integer getBookId() {
        return bookId;
    }
}
