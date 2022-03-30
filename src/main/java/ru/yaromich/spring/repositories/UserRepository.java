package ru.yaromich.spring.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.yaromich.spring.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> findOneByUserName(String userName);
    Optional<User> findById(Long id);
}
