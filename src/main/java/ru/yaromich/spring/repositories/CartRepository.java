package ru.yaromich.spring.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.yaromich.spring.entities.Cart;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {
    Optional<Cart> findCarByProductIdAndUserId(Long productId, Long userId);
    Set<Cart> findAllByUserId(Long userId);
}
