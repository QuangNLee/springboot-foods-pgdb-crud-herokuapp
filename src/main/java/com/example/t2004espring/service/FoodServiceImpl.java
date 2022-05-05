package com.example.t2004espring.service;

import com.example.t2004espring.entity.Food;
import com.example.t2004espring.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    FoodRepository foodRepository;

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Food> findById(int id) {
        return foodRepository.findById(id);
    }

    @Override
    public Food update(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public boolean delete(Food food) {
        foodRepository.delete(food);
        return true;
    }
}
