package com.katapios.tacos.repository;

import java.util.Optional;

import com.katapios.tacos.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
