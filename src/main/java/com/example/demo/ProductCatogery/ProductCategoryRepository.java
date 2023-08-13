package com.example.demo.ProductCatogery;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "product category",path = "product-category")
public interface ProductCategoryRepository  extends JpaRepository<ProductCatogery,Long> {
}
