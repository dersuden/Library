package org.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        GetInfoAboutBook getInfoAboutBook = new GetInfoAboutBook();
        GetInfoAboutOwner getInfoAboutOwner = new GetInfoAboutOwner();
        AddBook addBook = new AddBook();
        AddOwner addOwner = new AddOwner();
        BorrowBook borrowBook = new BorrowBook();
        getInfoAboutBook.getInfo();
        getInfoAboutOwner.getInfoAboutOwner();
        borrowBook.borrowBook();
    }
}
