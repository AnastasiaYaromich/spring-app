package com.yaromich.spring.repositories;

import com.yaromich.spring.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
    Product findOneById(Long id);
}
