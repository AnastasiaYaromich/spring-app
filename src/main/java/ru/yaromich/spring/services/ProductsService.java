package ru.yaromich.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yaromich.spring.entities.Product;
import ru.yaromich.spring.repositories.ProductsRepository;
import ru.yaromich.spring.utils.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setStudentsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    // get
    public Product getProductById(Long id) {
        Optional<Product> product = productsRepository.findById(id);
        if (!product.isPresent()) {
            throw new ProductNotFoundException("Product with id = " + id + " not found");
        }
        return product.get();
    }

    // post put
    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }

    // delete
    public void delete(Long id) {
        Optional<Product> product = productsRepository.findById(id);
        if (!product.isPresent()) {
            throw new ProductNotFoundException("Product with id = " + id + " not found");
        }
        productsRepository.delete(product.get());
    }

    // get
    public List<Product> getAllProductsList() {
        return (List<Product>) productsRepository.findAll();
    }

}
