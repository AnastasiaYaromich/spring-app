package ru.yaromich.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yaromich.spring.entities.Product;
import ru.yaromich.spring.services.ProductsService;

import java.util.List;

@RequestMapping("/api/**")
@RestController
public class ProductsRestController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productsService.getProductById(productId);
    }

    @GetMapping("/products")
    public List<Product> getProductById() {
        return productsService.getAllProductsList();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        product = productsService.saveOrUpdate(product);
        return product;
    }

    @PutMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product) {
        product = productsService.saveOrUpdate(product);
        return product;
    }

    @DeleteMapping("/products/{productId}")
    public int deleteProduct(@PathVariable Long productId) {
        productsService.delete(productId);
        return HttpStatus.OK.value();
    }
}
