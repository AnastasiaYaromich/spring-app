package ru.yaromich.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.yaromich.spring.entities.Category;
import ru.yaromich.spring.entities.Producer;
import ru.yaromich.spring.entities.Product;
import ru.yaromich.spring.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {this.productsRepository = productsRepository;}

    public ProductsService() {}

    public List<Product> getAllProductsList() {
        return (List<Product>)productsRepository.findAll();
    }

    public void addProduct(Product p, long idByCategoryName, long idByProducerName) {
        p.setId(21L);
        p.setCategory(new Category(idByCategoryName, p.getCategory().getName()));
        p.setProducer(new Producer(idByProducerName, p.getProducer().getName()));
        productsRepository.save(p);
    }

    public void removeById(Long id) {
        productsRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productsRepository.findOneById(id);
    }

    public Category getCategoryByProductId(Long id) {
        return productsRepository.findOneById(id).getCategory();
    }

    public Long getIdByCategoryName(String name, List<Category> categories) {
        for (Category category : categories)
            if(category.getName().equals(name)) {
                return category.getId();
            }
    return null;
    }

    public Long getIdByProducerName(String name, List<Producer> producers) {
        for (Producer producer : producers)
            if(producer.getName().equals(name)) {
                return producer.getId();
            }
        return null;
    }

    public Producer getProducerByProductId(Long id) {
        return productsRepository.findOneById(id).getProducer();
    }

    public void update(long id, Product updatedProduct, long idByCategoryName, long idByProducerName) {
        Product productToBeUpdated = getProductById(id);
        productToBeUpdated.setBrand(updatedProduct.getBrand());
        productToBeUpdated.setPrice(updatedProduct.getPrice());
        productToBeUpdated.setView(updatedProduct.getView());
        productToBeUpdated.setDescription(updatedProduct.getDescription());
        productToBeUpdated.setComposition(updatedProduct.getComposition());
        productToBeUpdated.setCategory(new Category(idByCategoryName, updatedProduct.getCategory().getName()));
        productToBeUpdated.setProducer(new Producer(idByProducerName, updatedProduct.getProducer().getName()));
        productToBeUpdated.setBigview(updatedProduct.getBigview());
        productsRepository.save(productToBeUpdated);
    }

    public void delete(long id) {
        Product productToBeDeleted = getProductById(id);
        productsRepository.delete(productToBeDeleted);
    }
}

