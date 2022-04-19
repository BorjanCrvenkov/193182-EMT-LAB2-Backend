package mk.ukim.finki.lab2.model;

import lombok.Data;
import mk.ukim.finki.lab2.model.enumerations.BookCategory;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;


@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Author author;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    private Integer availableCopies;

    public Book() {
    }

    public Book(String name, Author author, BookCategory category, Integer availableCopies) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
    }
}
