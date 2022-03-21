package ru.yaromich.spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.yaromich.spring.entities.Category;
import ru.yaromich.spring.entities.Role;
import ru.yaromich.spring.entities.User;
import java.util.List;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    List<Role> findAll();
    Role findOneByName(String theRoleName);
}

