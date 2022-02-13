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
@RequestMapping("/onlineStorage")
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
        public String getForm(Model model) {
            Product product = new Product();
            model.addAttribute("product", product);
            return "feedAdd";
        }

        @RequestMapping(params = "form", method = RequestMethod.POST)
    public String create(Product product) {
    //    productService.addProduct(product);
        return "feedAdd";
    }
}
