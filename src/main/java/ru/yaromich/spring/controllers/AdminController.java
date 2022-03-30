package ru.yaromich.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yaromich.spring.entities.Product;
import ru.yaromich.spring.entities.Role;
import ru.yaromich.spring.entities.User;
import ru.yaromich.spring.services.RoleService;
import ru.yaromich.spring.services.UserService;
import ru.yaromich.spring.services.UserServiceImpl;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public String adminHome(Principal principal, Model model) {
        List<Role> allRoles = roleService.getAllRoleList();
        model.addAttribute("allRoles", allRoles);
        return "admin";
    }
}
