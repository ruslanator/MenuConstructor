package ru.ruslanator.productservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ruslanator.productservice.models.Ingredient;
import ru.ruslanator.productservice.models.Recipe;
import ru.ruslanator.productservice.repositories.IngredientRepository;
import ru.ruslanator.productservice.repositories.RecipeRepository;
import ru.ruslanator.productservice.services.RecipeService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepo;

    @Override
    public Optional<Recipe> findById(int id) {
        return recipeRepo.findById(id);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepo.findAll();
    }

    @Override
    public void deleteById(int id) {
        recipeRepo.deleteById(id);
    }

    @Override
    public void create(Recipe recipe) {
        recipeRepo.save(recipe);
    }

    @Override
    public void addIngredient(int id, Ingredient ingredient) {
        Recipe recipe = recipeRepo.findById(id).get();
        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredient);
        recipe.setIngredients(ingredients);
        recipeRepo.save(recipe);
    }

    private void sumNutrients(Recipe recipe) {
        recipe.setProteins(0);
        recipe.setCarbs(0);
        recipe.setFats(0);
        recipe.setCalories(0);
        recipe.setProteins(recipe.getIngredients().stream()
                .mapToInt(Ingredient::getProteins).sum());
        recipe.setCarbs(recipe.getIngredients().stream()
                .mapToInt(Ingredient::getCarbs).sum());
        recipe.setFats(recipe.getIngredients().stream()
                .mapToInt(Ingredient::getFats).sum());
        recipe.setCalories(recipe.getIngredients().stream()
                .mapToInt(Ingredient::getCalories).sum());
    }
}
