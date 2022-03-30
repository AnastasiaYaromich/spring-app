package ru.yaromich.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.yaromich.spring.entities.Category;
import ru.yaromich.spring.entities.Producer;
import ru.yaromich.spring.repositories.CategoriesRepository;
import ru.yaromich.spring.repositories.ProducersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProducersService {
    private ProducersRepository producersRepository;

    @Autowired
    public void setProducersRepository(ProducersRepository producersRepository) {
        this.producersRepository = producersRepository;
    }

    public List<Producer> getAllProducersList() {
        return (List<Producer>) producersRepository.findAll();
    }

    public Producer getProducerById(Long id) {
        Optional<Producer> producer = producersRepository.findById(id);
        if (producer.isPresent()) {
            return producer.get();
        }
        return null;
    }
}
