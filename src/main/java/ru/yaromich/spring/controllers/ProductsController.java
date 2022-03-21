package ru.yaromich.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yaromich.spring.entities.Category;
import ru.yaromich.spring.entities.Product;
import ru.yaromich.spring.services.CategoriesService;
import ru.yaromich.spring.services.ProducersService;
import ru.yaromich.spring.services.ProductsService;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductsService productsService;
    private CategoriesService categoriesService;
    private ProducersService producersService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Autowired
    public void setCategoriesService(CategoriesService categoriesService) { this.categoriesService = categoriesService; }

    @Autowired
    public void setProducersService(ProducersService producersService) { this.producersService = producersService; }

    @GetMapping()
    public String productsList(Model model) {
          List<Product> allProducts = productsService.getAllProductsList();
          model.addAttribute("products", allProducts);
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productsService.getProductById(id));
        model.addAttribute("productCategory", productsService.getCategoryByProductId(id));
        model.addAttribute("productProducer", productsService.getProducerByProductId(id));
        return "show-product-info";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productsService.getProductById(id));
        model.addAttribute("productCategory", productsService.getCategoryByProductId(id));
        model.addAttribute("productProducer", productsService.getProducerByProductId(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product") Product product, @PathVariable("id") Long id) {
       Long idByCategoryName = productsService.getIdByCategoryName(product.getCategory().getName(), categoriesService.getAllCategoriesList());
       Long idByProducerName = productsService.getIdByProducerName(product.getProducer().getName(), producersService.getAllProducersList());
       productsService.update(id, product, idByCategoryName, idByProducerName);
        return "redirect:/products";
    }


    @GetMapping("/remove/{id}")
    public String delete(@PathVariable("id") Long id) {
        productsService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/add")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "add";
    }

    @PatchMapping("/create")
    public String create(@ModelAttribute("product") Product product) {
        Long idByCategoryName = productsService.getIdByCategoryName(product.getCategory().getName(), categoriesService.getAllCategoriesList());
        Long idByProducerName = productsService.getIdByProducerName(product.getProducer().getName(), producersService.getAllProducersList());
        productsService.addProduct(product, idByCategoryName, idByProducerName);
        return "redirect:/products";
    }
}
