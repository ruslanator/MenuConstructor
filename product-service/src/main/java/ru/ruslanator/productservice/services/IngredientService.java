package ru.ruslanator.productservice.services;

import org.springframework.stereotype.Service;
import ru.ruslanator.productservice.models.Ingredient;

import java.util.List;
import java.util.Optional;

@Service
public interface IngredientService {
    Optional<Ingredient> findById(int id);
    Optional<Ingredient> findByName(String name);
    List<Ingredient> findAll();
    void deleteById(int id);
    void create(Ingredient ingredient);
}
