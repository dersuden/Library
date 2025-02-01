package org.example.library;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private Long year;
    private String author;
    private String popularity;


    public Book(String name, Long year, String author, String popularity) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.popularity = popularity;
    }
}
