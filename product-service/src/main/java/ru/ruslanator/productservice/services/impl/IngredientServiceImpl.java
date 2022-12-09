package ru.ruslanator.productservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ruslanator.productservice.models.entities.Ingredient;
import ru.ruslanator.productservice.repositories.IngredientRepository;
import ru.ruslanator.productservice.services.IngredientService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepo;

    @Override
    public Optional<Ingredient> findById(int id) {
        return ingredientRepo.findById(id);
    }

    @Override
    public Optional<Ingredient> findByName(String name) {
        return ingredientRepo.findByName(name);
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepo.findAll();
    }

    @Override
    public void deleteById(int id) {
        ingredientRepo.deleteById(id);
    }

    @Override
    public void create(Ingredient ingredient) {
        ingredientRepo.save(ingredient);
    }
}
