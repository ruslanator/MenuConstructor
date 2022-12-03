package ru.ruslanator.productservice.services;

import org.springframework.stereotype.Service;
import ru.ruslanator.productservice.models.Ingredient;
import ru.ruslanator.productservice.models.Recipe;

import java.util.List;
import java.util.Optional;

@Service
public interface RecipeService {
    Optional<Recipe> findById(int id);
    List<Recipe> findAll();
    void deleteById(int id);
    void create(Recipe recipe);
    void addIngredient(int id, Ingredient ingredient);
}
