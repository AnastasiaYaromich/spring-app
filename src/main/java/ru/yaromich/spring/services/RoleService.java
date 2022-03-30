package ru.yaromich.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.yaromich.spring.entities.Role;
import ru.yaromich.spring.repositories.RoleRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoleList() {
        return (List<Role>) roleRepository.findAll();
    }
}
