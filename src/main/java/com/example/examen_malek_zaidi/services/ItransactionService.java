package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.Transaction;
import com.example.examen_malek_zaidi.entities.TypeTransaction;

import java.util.List;

public interface ItransactionService {
    public String ajouterVirement(Transaction transaction);
    public String ajouterRetrait(Transaction transaction);

    public String ajouterVersement(Transaction transaction);
    public List<Transaction> getAllTransactionByTypeAndCompte(TypeTransaction type, long idCompte);
}
/*
 @Query("SELECT p FROM Product p WHERE p.price > :minPrice")
    List<Product> findByPriceGreaterThan(double minPrice);

    @Query("SELECT c, o FROM Customer c LEFT JOIN Order o ON c.id = o.customer.id")
    List<Object[]> findAllCustomersWithOrders();
     @Query("SELECT o FROM Order o WHERE o.customer.id = :customerId")
    List<Order> findOrdersByCustomerId(@Param("customerId") Long customerId);
}
@Query("SELECT b FROM Book b JOIN b.author a WHERE a.id = :authorId")
    List<Book> findBooksByAuthorId(@Param("authorId") Long authorId);
* */