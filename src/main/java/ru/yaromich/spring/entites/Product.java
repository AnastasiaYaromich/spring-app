package ru.yaromich.spring.entites;

public class Product {
    private int id;
    private String title;
    private String cost;

    public Product(int id, String title, String cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product() {

    }

    public void setId(int id) { this.id = id; }

    public void setTitle(String title) { this.title = title; }

    public void setCost(String cost) { this.cost = cost; }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCost() { return cost; }

    @Override
    public String toString() {
        return id + ". " + title + " for cats - " + cost;
    }
}
