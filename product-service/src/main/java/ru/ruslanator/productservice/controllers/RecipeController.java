package ru.ruslanator.productservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ruslanator.productservice.models.entities.Ingredient;
import ru.ruslanator.productservice.models.entities.Recipe;
import ru.ruslanator.productservice.services.RecipeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/{id}")
    public Optional<Recipe> getRecipe(@PathVariable int id) {
        return recipeService.findById(id);
    }

    @GetMapping("/list")
    public List<Recipe> getAll() {
        return recipeService.findAll();
    }

    @PostMapping("/create")
    public void createRecipe(@RequestBody Recipe recipe) {
        recipeService.create(recipe);
    }

    @PostMapping("/remove/{recipeId}-{ingredientId}")
    public void deleteIngredient(@PathVariable int recipeId, @PathVariable int ingredientId) {
        recipeService.deleteIngredient(recipeId, ingredientId);
    }

    @PostMapping("/remove/{id}")
    public void deleteRecipe(@PathVariable int id) {
        recipeService.deleteById(id);
    }

    @PostMapping("/add/{recipeId}-{ingredientId}")
    public void addIngredient(@PathVariable int recipeId, @PathVariable int ingredientId) {
        recipeService.addIngredient(recipeId, ingredientId);
    }
}
