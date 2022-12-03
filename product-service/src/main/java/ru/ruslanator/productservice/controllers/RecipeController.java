package ru.ruslanator.productservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ruslanator.productservice.models.Ingredient;
import ru.ruslanator.productservice.models.Recipe;
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

    @PostMapping("/add/{id}")
    public void addIngredient(@RequestBody Ingredient ingredient, @PathVariable int id) {
        recipeService.addIngredient(id, ingredient);
    }

    @PostMapping
    public void deleteRecipe(int id) {
        recipeService.deleteById(id);
    }
}
