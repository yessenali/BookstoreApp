package com.example.bookstore.services;

import com.example.bookstore.entities.Category;
import com.example.bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category edit(int id) {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = null;
        if (optional.isPresent()) {
            category = optional.get();
        } else {
            throw new RuntimeException("Product not found " + id);
        }

        return category;

    }

    @Override
    public void delete(int n) {
        categoryRepository.deleteById(n);
    }

    @Override
    public Category getCategoryById(int n) {
        return categoryRepository.getById(n);
    }
}
