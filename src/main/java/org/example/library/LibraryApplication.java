package org.example.library;

import org.example.library.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        Book testBook = new Book(6, "Test", 1998, "Me", "1");
        System.out.println(testBook);
        Book newTestBook = new Book(7, "Bruh", 1997, "U", "0");
        System.out.println(newTestBook);
        Book findBook = new Book("Lord of the flies");
        System.out.println("Lord of the flies");
    }
}
