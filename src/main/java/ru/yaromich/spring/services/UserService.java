package ru.yaromich.spring.services;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.yaromich.spring.entities.Role;
import ru.yaromich.spring.entities.SystemUser;
import ru.yaromich.spring.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    void save(SystemUser systemUser);
}
