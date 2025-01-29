package org.example.library;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Name;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

    protected Book() {

    }

    public Book(int id, String name, int year, String author, String popularity) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.author = author;
        this.popularity = popularity;
    }

    public Book(String name) {
        this.name = name;
    }
}
