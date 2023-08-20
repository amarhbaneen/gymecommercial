package com.example.demo.Product;


import com.example.demo.ProductCatogery.ProductCatogery;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;



@Entity
@Table(name="product")
@Data

public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_Id")
    private Long productId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "category_id",nullable = false)
    private Long categoryId;
    @Column(name = "price")
    private int price;
    @Column(name = "stock_Quantity")
    private int stockQuantity;
    @Column(name = "image_Url")
    private String imageUrl;
    @Column(name = "created_At")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_At")
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public Product( String name, String description, Long categoryId, int price, int stockQuantity, String imageUrl, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product() {
    }




}
