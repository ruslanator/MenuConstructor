package ru.ruslanator.productservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.ruslanator.productservice.models.dto.RecipeDTO;
import ru.ruslanator.productservice.models.entities.Ingredient;
import ru.ruslanator.productservice.models.entities.Recipe;
import ru.ruslanator.productservice.repositories.IngredientRepository;
import ru.ruslanator.productservice.repositories.RecipeRepository;
import ru.ruslanator.productservice.services.RecipeService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepo;
    private final IngredientRepository ingredientRepo;

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
    public void addIngredient(int recipeId, int ingredientId) {
        Recipe recipe = recipeRepo.findById(recipeId).get();
        Ingredient ingredient = ingredientRepo.findById(ingredientId).get();
        Set<Ingredient> ingredients = new HashSet<>(recipe.getIngredients());
        ingredients.add(ingredient);
        recipe.setIngredients(ingredients);
        sumNutrients(recipe);
        recipeRepo.save(recipe);
    }

    @Override
    public void deleteIngredient(int recipeId, int ingredientId) {
        Recipe recipe = recipeRepo.findById(recipeId).get();
        Ingredient ingredient = ingredientRepo.findById(ingredientId).get();
        Set<Ingredient> ingredients = new HashSet<>(recipe.getIngredients());
        ingredients.remove(ingredient);
        recipe.setIngredients(ingredients);
        sumNutrients(recipe);
        recipeRepo.save(recipe);
    }

    private void sumNutrients(Recipe recipe) {
        recipe.setProteins(recipe.getIngredients().stream()
                .mapToInt(Ingredient::getProteins).sum());
        recipe.setCarbs(recipe.getIngredients().stream()
                .mapToInt(Ingredient::getCarbs).sum());
        recipe.setFats(recipe.getIngredients().stream()
                .mapToInt(Ingredient::getFats).sum());
        recipe.setCalories(recipe.getIngredients().stream()
                .mapToInt(Ingredient::getCalories).sum());
    }

    private RecipeDTO convertToDTO(Recipe recipe) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(recipe, RecipeDTO.class);
    }
}
