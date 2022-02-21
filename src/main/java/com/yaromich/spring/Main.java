package com.yaromich.spring;

import com.yaromich.spring.entities.Category;
import com.yaromich.spring.entities.Product;
import com.yaromich.spring.entities.ProductDao;

public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        System.out.println(productDao.getProductById(2));
   //    productDao.deleteById(2);
     //   System.out.println(productDao.getAllProducts());
    }
}
