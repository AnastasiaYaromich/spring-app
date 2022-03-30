package ru.yaromich.spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.yaromich.spring.entities.Category;
import ru.yaromich.spring.entities.Producer;
import java.util.List;

@Repository
public interface ProducersRepository extends PagingAndSortingRepository<Producer, Long> {
   List<Producer> findAll();
}

