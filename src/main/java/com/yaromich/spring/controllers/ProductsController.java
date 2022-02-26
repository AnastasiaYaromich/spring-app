package com.yaromich.spring.controllers;

import com.yaromich.spring.entities.Product;
import com.yaromich.spring.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
    @RequestMapping("/products")
    public class ProductsController {
        private ProductsService productsService;

        @Autowired
        public void setProductsService(ProductsService productsService) {
            this.productsService = productsService;
        }

        @RequestMapping("/home")
        public String homePage() {
            return "index";
        }

        @RequestMapping(value = "/showAllProducts", method = RequestMethod.GET)
        public String showProductsList(Model model) {
            List<Product> allProducts = productsService.getAllStudentsList();
            model.addAttribute("productsList", allProducts);
            return "products-list";
        }

        @RequestMapping(path="/showProductById/{id}", method=RequestMethod.GET)
        public String showProductById(@PathVariable(value = "id") Long productId, Model model) {
        Product product = productsService.getProductById(productId);
        model.addAttribute("product", product);
        return "product-form-result";
        }

        @RequestMapping(path="/addProduct", method=RequestMethod.GET)
        public String showAddForm(Model model) {
        Product product = new Product();
        product.setTitle("Unknown");
        model.addAttribute("product", product);
        return "add-product-form";
        }

        @RequestMapping(path="/addProduct", method=RequestMethod.POST)
        public String addProduct(Product product) {
            System.out.println(product.getTitle());
        productsService.addProduct(product);
        return "redirect:/products/showAllProducts";
        }

        @RequestMapping(path="/removeProduct/{id}", method=RequestMethod.GET)
        public String removeById(@PathVariable(value = "id") Long productId) {
        productsService.removeById(productId);
        return "redirect:/products/showAllProducts";
    }
}

