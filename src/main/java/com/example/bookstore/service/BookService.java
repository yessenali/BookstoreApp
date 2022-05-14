package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Book;
import net.javaguides.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> getById(Integer product_id){
        return bookRepository.findById(product_id);
    }
}
