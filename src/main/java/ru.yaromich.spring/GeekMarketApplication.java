package ru.yaromich.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeekMarketApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(GeekMarketApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		List<ProductDTO> products = repository.getProducts(1).stream().collect(toCollection(ArrayList::new));
//		System.out.println(products);
    }
}