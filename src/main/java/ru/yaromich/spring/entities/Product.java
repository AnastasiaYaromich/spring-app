package ru.yaromich.spring.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Long cost;

    public Product() {}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public Long getCost() {return cost;}
    public void setCost(Long cost) {this.cost = cost;}

    @Override
    public String toString() {
        return "Product id=" + id + ", title='" + title + '\'' + ", cost=" + cost + '}';
    }
}