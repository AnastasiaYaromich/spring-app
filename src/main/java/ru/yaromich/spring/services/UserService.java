package ru.yaromich.spring.services;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.yaromich.spring.entities.Cart;
import ru.yaromich.spring.entities.Role;
import ru.yaromich.spring.entities.SystemUser;
import ru.yaromich.spring.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService extends UserDetailsService {
    Optional<User> findByUserName(String userName);
    void save(SystemUser systemUser);
    Optional<User> findById(Long id);
}
