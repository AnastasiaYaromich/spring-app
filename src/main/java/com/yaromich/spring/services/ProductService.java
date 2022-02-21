package com.yaromich.spring.services;

import com.yaromich.spring.entities.Product;
import com.yaromich.spring.repositories.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import java.util.List;
//import java.util.Optional;


//@Service
public class ProductService {
    private ProductRepository productRepository;

//    @Autowired
//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

//
//    public List<Product> getAllProducts() {
//        List<Product> products = (List<Product>) productRepository.findAll();
//        return products;
//    }
//
//    public List<Product> getProductsByVendorCode(String code) {
//        return productRepository.findAllByVendorCode(code);
//    }
////
//    public Product getProductById(Long id) {
//        Optional<Product> product = productRepository.findById(id);
//        if (product.isPresent()) {
//            return product.get();
//        }
//        return null;
//    }

}
