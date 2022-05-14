package net.javaguides.springboot.model;

import lombok.*;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Book")
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_id_seq",
            sequenceName = "book_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_id_seq"
    )
    @Column(name = "book_id")
    @Getter @Setter private int book_id;

    @Column (
            name = "book_name",
            nullable = false
    )
    @NonNull @Getter @Setter private String book_name;

    @Column (
            name = "book_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NonNull @Getter @Setter private String book_description;

    @Column (name = "book_price")
    @NonNull @Getter @Setter private long book_price;

    @Column (name = "book_img")
    @Getter @Setter private String book_img;

    @Column (name = "book_review_no")
    @NonNull @Getter @Setter private int book_review_no;

    @Column (name = "book_sku")
    @NonNull @Getter @Setter private int book_sku;

    @Column (name = "book_discount")
    @Getter @Setter private int book_discount;

    @Column (name = "book_discount_price")
    @Getter @Setter private long book_discount_price;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "book_category_id", referencedColumnName = "category_id", nullable = false)
    @Getter @Setter private Category category;

}
