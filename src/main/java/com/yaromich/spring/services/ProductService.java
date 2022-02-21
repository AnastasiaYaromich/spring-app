package com.yaromich.spring.services;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import java.util.List;


import com.yaromich.spring.entities.Product;
import com.yaromich.spring.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }


    public List<Product> getAllProducts() {
        List<Product> products = (List<Product>) productDao.getAllProducts();
        return products;
    }

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
