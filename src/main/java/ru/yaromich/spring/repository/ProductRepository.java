package ru.yaromich.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yaromich.spring.entites.Product;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
     List<Product> products = new ArrayList<Product>() {{
        add(new Product(1, "Orijen", "15$"));
        add(new Product(2, "Acana", "16$"));
        add(new Product(3, "Sanabelle", "10$"));
        add(new Product(4, "Monge BWild", "8$"));
        add(new Product(5, "Primordial", "17$"));
        add(new Product(6, "Brit Care", "11$"));
        add(new Product(7, "Royal Canin", "4$"));
        add(new Product(8, "Hills", "5$"));
        add(new Product(9, "Unica Natura", "5$"));
        add(new Product(10, "Carny", "10$"));
    }};

    public void setProductList(List<Product> productList) {
        products = productList;
    }

    // Выдать список всех товаров.
    public List<Product> productList () {
        return products;
    }

    // Найти товар по id.
    public Product findProductById(Long id) {
        for (Product product: products)
            if(product.getId() == id) { return product; }
        return null;
    }

    public void addProduct() {

    }
}

