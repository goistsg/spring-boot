package br.com.bb.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends Repository<Product, Long> {

    @Query("SELECT p FROM Product p where p.category.id = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);

    Product findById(Long id);

    List<Product> findAll();
}
