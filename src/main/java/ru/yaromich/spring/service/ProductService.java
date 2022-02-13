package ru.yaromich.spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yaromich.spring.entites.Product;
import ru.yaromich.spring.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> showAll() {
        return productRepository.productList();
    }

    public Product showById(Long id) {
        return productRepository.findProductById(id);
    }
}
