package ru.ruslanator.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ruslanator.productservice.models.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
