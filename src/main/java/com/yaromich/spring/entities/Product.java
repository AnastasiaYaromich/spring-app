package com.yaromich.spring.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public Product() {

    }

    public long getId() {
        return id;
    }

    public Product(int id, String title, int price){
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
//    @JoinTable(
//            name = "products_categories",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id")
//    )
//    private List<Category> categories;
//
//    public List<Category> getCategories() {
//        return categories;
//    }

//    public void setCategories(List<Category> categories) {
//        this.categories = categories;
//    }

    @Override
    public String toString() {
//        String allCategories = "";
//        for (Category o : categories) {
//            allCategories += o.getName() + " ";
//        }
        return "Product [" + id + " " + title + " " + price + "]";
    }
}
