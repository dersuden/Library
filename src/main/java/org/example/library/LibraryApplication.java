package org.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LibraryApplication {

    private final BookRepository bookRepository;

    @Autowired
    public LibraryApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void applicationReady() {
        try {
            Book book1 = new Book("Elden Ring artbook", 2023L, "BANDAI NAMCO", "30");
            Book book2 = new Book("1984", 1949L, "George Orwell", "84");
            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.flush();
            System.out.println("Книги успешно добавлены в базу данных!");
        } catch (Exception exception) {
            System.err.println("Ошибка при добавлении книг в базу данных: " + exception.getMessage());
            exception.printStackTrace();
            throw exception;
        }
    }
}
