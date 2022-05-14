package net.javaguides.springboot.model;

import lombok.*;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "category")
@Table(name = "category")
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_id_seq",
            sequenceName = "category_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "category_id_seq"
    )
    @Column(name = "category_id")
    private int category_id;

    @Column(
            name = "category_name",
            nullable = false,
            unique = true
    )
    private String category_name;

    @OneToMany(mappedBy = "category", targetEntity = Book.class, cascade = CascadeType.ALL)
    private Set<Book> books;
}

