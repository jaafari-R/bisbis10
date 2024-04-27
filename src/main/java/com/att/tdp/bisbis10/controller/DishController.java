package com.att.tdp.bisbis10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.service.DishService;

@RestController
@RequestMapping("restaurants/{restaurantId}/dishes")
public class DishController {
    DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> getDishesByRestaurantId(@PathVariable Integer restaurantId) {
        List<Dish> dishes = dishService.getDishesByRestaurantId(restaurantId);
        return dishes;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addDish(@PathVariable Integer restaurantId, @RequestBody Dish dish) {
        dishService.addDish(restaurantId, dish);
    }

    @DeleteMapping("/{dishId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDish(@PathVariable Integer restaurantId, @PathVariable Integer dishId) {
        dishService.deleteDish(restaurantId, dishId);
    }
}
