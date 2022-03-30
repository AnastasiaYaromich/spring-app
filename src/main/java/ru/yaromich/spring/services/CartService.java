package ru.yaromich.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.yaromich.spring.entities.Cart;
import ru.yaromich.spring.entities.Product;
import ru.yaromich.spring.entities.User;
import ru.yaromich.spring.repositories.CartRepository;
import ru.yaromich.spring.repositories.UserRepository;

import java.util.*;

@Service
public class CartService {

    private CartRepository cartRepository;
   private UserService userService;
   private ProductsService productsService;

    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }

    @Autowired
    public void setProductsService(ProductsService productsService) { this.productsService = productsService; }

    public Set<Cart> getProductsByUserId(Long id) {
        Set<Cart> carts = (Set<Cart>) cartRepository.findAllByUserId(id);
        return carts;
    }

    public void add(Long product_id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userService.findByUserName(username);
       Optional<Cart> userCart = cartRepository.findCarByProductIdAndUserId(product_id, user.get().getId());
        if(userCart.isPresent()) {
            userCart.get().setCount(userCart.get().getCount() + 1);
            cartRepository.save(userCart.get());
        } else {
            Cart cart = new Cart();
            cart.setUser(user.get());
            cart.setProduct(productsService.getProductById(product_id));
            cart.setCount(1L);
            cartRepository.save(cart);
        }
    }


    public void delete(Long product_id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userService.findByUserName(username);
        Optional<Cart> userCart = cartRepository.findCarByProductIdAndUserId(product_id, user.get().getId());
        if(userCart.isPresent()) {
            if (userCart.get().getCount() <= 1) {
                cartRepository.delete(userCart.get());
            } else {
                userCart.get().setCount(userCart.get().getCount() - 1);
                cartRepository.save(userCart.get());
            }
        }
    }



    public Long calculate(Set<Cart> productsInCart) {
        ArrayList<String> commonPrice = new ArrayList<>();
        ArrayList<Long> count = new ArrayList<>();
        for (Cart cart: productsInCart) {
            commonPrice.add(cart.getProduct().getPrice());
            count.add(cart.getCount());
        }
        ArrayList<Long> price = new ArrayList<>();
        for (String s: commonPrice) {
            Long l = Long.parseLong(s.substring(0, s.length() - 1));
            price.add(l);
        }
        ArrayList<Long> totalPrice = new ArrayList<>();
        for (int i = 0, j = 0; i < price.size(); i++, j++) {
            totalPrice.add(i, price.get(i) * count.get(j));
        }
        Long totalSum = 0L;
        for (Long l: totalPrice) {
            totalSum = totalSum + l;
        }
      return totalSum;
    }
}
