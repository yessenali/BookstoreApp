package com.example.bookstoreapplication.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private static final List<Book> BOOKS = Arrays.asList(
            new Book(1, "Kemel Adam"),
            new Book(2, "Гибкое сознание"),
            new Book(3, "Road to the goal")
    );

    @GetMapping(path = "{bookId}")
    public Book getBook(@PathVariable("bookId") Integer bookId) {
        return BOOKS.stream()
                .filter(book -> bookId.equals(book.getBookId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Book " + bookId + " does not exist"));
    }
}
