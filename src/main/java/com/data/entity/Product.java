package com.data.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "product")
@NamedQuery(name = "findProductByName",query = "FROM Product p WHERE p.name = :name")
@NamedQuery(name="findProductByPrice",query = "FROM Product p where p.price > :price")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private double rating;

    @ManyToMany
    @JoinTable(
            name = "product_category_map",
            joinColumns = @JoinColumn(name = "product_id"),         // FK to product
            inverseJoinColumns = @JoinColumn(name = "category_id")  // FK to category
    )
    private List<Category> categoryList = new ArrayList<>();

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void addCategory(Category category){
        categoryList.add(category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
