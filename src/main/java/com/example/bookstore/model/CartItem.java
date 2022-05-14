package net.javaguides.springboot.model;


import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CartItem {
    @Id
    @Column(name = "cart_item_id", nullable = false)
    @Getter @Setter private Integer cart_item_id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @NonNull @Getter @Setter private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull @Getter @Setter private User user;

    @NonNull @Getter @Setter private int quantity;
}
