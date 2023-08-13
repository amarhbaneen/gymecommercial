package com.example.demo.ProductCatogery;

import com.example.demo.Product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "product_category")
@Getter
@Setter

public class ProductCatogery {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name="categoryname")
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set<Product> products;



}
