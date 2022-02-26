package com.yaromich.spring.services;
import com.yaromich.spring.entities.Product;
import com.yaromich.spring.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public ProductsService() {}

    public List<Product> getAllStudentsList() {
        return (List<Product>)productsRepository.findAll();
    }

    public void addProduct(Product p) {
        productsRepository.save(p);
    }

    public void removeById(Long id) {
        productsRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
       return productsRepository.findOneById(id);
    }
}
