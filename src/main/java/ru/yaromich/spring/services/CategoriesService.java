package ru.yaromich.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.yaromich.spring.entities.Category;
import ru.yaromich.spring.repositories.CategoriesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    private CategoriesRepository categoriesRepository;

    @Autowired
    public void setCategoriesRepository(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<Category> getAllCategoriesList() {
        return (List<Category>) categoriesRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        Optional<Category> category = categoriesRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        return null;
    }
}
