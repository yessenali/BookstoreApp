package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Book;
import net.javaguides.springboot.model.CartItem;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.CartItemRepository;
import net.javaguides.springboot.service.BookService;
import net.javaguides.springboot.service.CartService;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CartController {
    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/cart.html")
    public String showShoppingCart(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getCurrentlyLoggedInUser(authentication);

        List<CartItem> cartItems = cartService.listCartItems(user);

        model.addAttribute("cartItems", cartItems);

        return "cart";
    }

    @GetMapping("/cart.html/addItem/{book_id}")
    public String addItemToCart(@PathVariable Integer book_id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getCurrentlyLoggedInUser(authentication);

        Optional<Book> book = bookService.getById(book_id);

        cartService.save(user, book.get(), 1);
        return "cart";
    }

    @GetMapping("/cart.html/clear")
    public String clearCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getCurrentlyLoggedInUser(authentication);

        System.out.println(user.getEmail());
        System.out.println(user.getId());

        cartService.clearByUserId(Math.toIntExact(user.getId()));
        return "cart";
    }
}
