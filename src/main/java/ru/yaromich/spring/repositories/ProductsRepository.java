package ru.yaromich.spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.yaromich.spring.entities.Category;
import ru.yaromich.spring.entities.Producer;
import ru.yaromich.spring.entities.Product;
import java.util.List;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findAll();
    Product findOneById(Long id);
}