package ru.yaromich.spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yaromich.spring.entites.Product;
import ru.yaromich.spring.repository.ProductRepository;
import ru.yaromich.spring.service.ProductService;
import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/feedPage")
    public String viewAllProducts(Model model) {
        List<Product> productList = productService.showAll();
        model.addAttribute("productList", productList);
        return "feedPage";
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String findProductById(Model model, @PathVariable(value =  "id") Long id) {
        Product product = productService.showById(id);
        model.addAttribute("product", product);
        return "feedFind";
    }

    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product, Model model) {
        List<Product> productList = productService.showAll();
        productList.add(product);
        productService.setProductList(productList);
        model.addAttribute("productList", productList);
        return "feedPage";
    }
}
