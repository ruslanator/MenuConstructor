package ru.ruslanator.productservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ruslanator.productservice.models.entities.Ingredient;
import ru.ruslanator.productservice.services.IngredientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("/{id}")
    public Optional<Ingredient> getIngredient(@PathVariable int id) {
        return ingredientService.findById(id);
    }

    @GetMapping("/list")
    public List<Ingredient> getAll() {
        return ingredientService.findAll();
    }

    @GetMapping("/name/{name}")
    public Optional<Ingredient> getIngredientByName(@PathVariable String name) {
        return ingredientService.findByName(name);
    }

    @PostMapping("/create")
    public void createIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.create(ingredient);
    }

    @PostMapping
    public void deleteRecipe(int id) {
        ingredientService.deleteById(id);
    }
}
