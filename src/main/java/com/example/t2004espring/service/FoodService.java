package com.example.t2004espring.service;

import com.example.t2004espring.entity.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    Food save(Food food);

    List<Food> findAll();

    Optional<Food> findById(int id);

    Food update(Food food);

    boolean delete(Food food);
}
