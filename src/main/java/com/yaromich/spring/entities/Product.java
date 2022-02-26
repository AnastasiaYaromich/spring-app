package com.yaromich.spring.entities;

import javax.persistence.*;

//1. Создать сущность «Товар» (id, название, стоимость) и соответствующую таблицу в БД. Заполнить таблицу тестовыми данными (20 записей).
//2. Сделать RestController позволяющий выполнять следующий набор операции над этой сущностью:
//получение товара по id [ GET .../app/products/{id} ]  ++
//получение всех товаров [ GET .../app/products ]
//создание нового товара [ POST .../app/products ]
//удаление товара по id.[ GET .../app/products/delete/{id} ]
//(Замечание: пока делаем немного не по правилам REST API, эта тема будет разбираться на следующих занятиях, поэтому удаление выполняется через http-метод GET, а не DELETE)

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