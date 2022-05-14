package net.javaguides.springboot.service;


import net.javaguides.springboot.model.Book;
import net.javaguides.springboot.model.CartItem;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.BookRepository;
import net.javaguides.springboot.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserService userService;

    public List<CartItem> listCartItems(User user) {
        return cartRepo.findByUser(user);
    }

    public void clearByUserId(Integer userId) {
        cartRepo.clearCartByUserId(userId);
    }

    public void save(User user, Book book, Integer quantity) {
        Integer maxId = cartRepo.getMaxId();
        CartItem cartItem = cartRepo.findByUserAndBook(user, book);

        if(cartItem != null) {
            int newQuantity = cartItem.getQuantity() + 1;
            cartItem.setQuantity(newQuantity);
        }
        else {
            if(maxId == null) cartItem = new CartItem(1, book, user, quantity);
            else cartItem = new CartItem(maxId+1, book, user, quantity);
        }
        cartRepo.save(cartItem);
    }
}