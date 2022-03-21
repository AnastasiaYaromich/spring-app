package ru.yaromich.spring.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private String price;

    @Column(name = "view")
    private String view;

    @Column(name = "bigview")
    private String bigview;

    @Column(name = "description")
    private String description;

    @Column(name = "composition")
    private String composition;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    public Producer getProducer() {return producer;}
    public void setProducer(Producer producer) {this.producer = producer;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}

    public String getPrice() {return price;}
    public void setPrice(String price) {this.price = price;}

    public String getView() {return view;}
    public void setView(String view) {this.view = view;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getComposition() {return composition;}
    public void setComposition(String composition) {this.composition = composition;}

    public String getBigview() {return bigview;}
    public void setBigview(String bigview) {this.bigview = bigview;}

    public Product() {}
}