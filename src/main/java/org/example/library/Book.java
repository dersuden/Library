package org.example.library;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int year;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String popularity;
    private String book;

    @OneToMany(mappedBy = "book")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public Book() {

    }

    public Book(int id, String name, int year, String author, String popularity) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.author = author;
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "Book" + "\n" +
                "id=" + id + "\n" +
                "name=" + name + "\n" +
                "year=" + year + "\n" +
                "author=" + author + "\n" +
                "popularity=" + popularity + "\n";
    }
}
