package org.example.library;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import org.example.library.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            Book testBook = new Book(7, "Test", 1998, "Me", "1");
            em.persist(testBook);
            transaction.commit();
            System.out.println("Получилось?");

        } catch (Exception exception) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if (em != null && em.isOpen());
            em.close();
            if (emf != null && emf.isOpen());
            emf.close();
        }
    }
}
