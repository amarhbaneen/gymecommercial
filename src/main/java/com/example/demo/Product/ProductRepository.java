package com.example.demo.Product;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin
public interface ProductRepository extends JpaRepository<Product,Long> {

    Page<Product> findByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);
    Page<Product> findBynameContaining(@Param("name") String name, Pageable pageable);


}
