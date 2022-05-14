package net.javaguides.springboot.repository;


import net.javaguides.springboot.model.Book;
import net.javaguides.springboot.model.CartItem;
import net.javaguides.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByUser(User user);

    CartItem findByUserAndBook(User user, Book book);

    @Query(value = "SELECT max(cart_item_id) FROM cart_item", nativeQuery = true)
    Integer getMaxId();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cart_item WHERE user_id = :user_id", nativeQuery = true)
    void clearCartByUserId(
            @Param("user_id") Integer status);
}
