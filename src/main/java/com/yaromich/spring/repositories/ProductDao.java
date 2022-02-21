package com.yaromich.spring.repositories;

import com.yaromich.spring.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductDao {
    private SessionFactory sessionFactory;

    public Product getProductById(int id){
        Session session = getSession();
        Product product = null;
        try{
            session.beginTransaction();
            product = session.get(Product.class, id);
        }finally {
            session.close();
            sessionFactory.close();
        }
        return product;
    }

    public List<Product> getAllProducts(){
        Session session = getSession();
        List<Product> productList;
        try{
            session.beginTransaction();
            productList = session.createQuery("from Product").getResultList();
        }finally {
            session.close();
            sessionFactory.close();
        }
        return productList;
    }

    public void addNewProduct(Product product){
        Session session = getSession();
        try{
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }

    public void deleteById(int id){
        Session session = getSession();
        try{
            Product product = getProductById(id);
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }

    public Session getSession(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
}
