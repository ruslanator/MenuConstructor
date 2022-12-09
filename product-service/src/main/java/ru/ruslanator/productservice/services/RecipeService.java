package ru.ruslanator.productservice.services;

import org.springframework.stereotype.Service;
import ru.ruslanator.productservice.models.dto.RecipeDTO;
import ru.ruslanator.productservice.models.entities.Ingredient;
import ru.ruslanator.productservice.models.entities.Recipe;

import java.util.List;
import java.util.Optional;

@Service
public interface RecipeService {
    Optional<Recipe> findById(int id);
    List<Recipe> findAll();
    void deleteById(int id);
    void create(Recipe recipe);
    void addIngredient(int recipeId, int ingredientId);
    void deleteIngredient(int recipeId, int ingredientId);
}
