package ru.yaromich.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yaromich.spring.entities.Product;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {
}
