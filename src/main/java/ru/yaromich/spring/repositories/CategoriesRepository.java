package ru.yaromich.spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.yaromich.spring.entities.Category;
import java.util.List;


@Repository
public interface CategoriesRepository extends PagingAndSortingRepository<Category, Long> {
    Category findOneById(Long id);
}
