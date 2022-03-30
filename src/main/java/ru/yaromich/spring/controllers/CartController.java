package ru.yaromich.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yaromich.spring.entities.Cart;
import ru.yaromich.spring.entities.Product;
import ru.yaromich.spring.entities.User;
import ru.yaromich.spring.services.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/cart")
public class CartController {

    private ProductsService productsService;
    private UserService userService;
    private CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) { this.cartService = cartService; }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

 @GetMapping("")
    public String cart( Model model) {
     String userName = SecurityContextHolder.getContext().getAuthentication().getName();
     Optional<User> user = userService.findByUserName(userName);
     Set<Cart> productsInCart = cartService.getProductsByUserId(user.get().getId());
     Long commonPrice = cartService.calculate(productsInCart);
     model.addAttribute("cart", productsInCart);
     model.addAttribute("totalPrice", commonPrice);
     return "cart";
 }

 @GetMapping("/{id}")
    public String add(Model model, @PathVariable("id") Long id) {
     Product product = productsService.getProductById(id);
     cartService.add(id);
     return "redirect:/cart";
 }

 @GetMapping("/remove/{id}")
public String remove(Model model, @PathVariable("id") Long id) {
        Product product = productsService.getProductById(id);
        cartService.delete(id);
        return "redirect:/cart";
 }
}
