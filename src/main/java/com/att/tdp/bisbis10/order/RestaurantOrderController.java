package com.att.tdp.bisbis10.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class RestaurantOrderController {
    RestaurantOrderService restaurantOrderService;

    @Autowired
    public RestaurantOrderController(RestaurantOrderService restaurantOrderService) {
        this.restaurantOrderService = restaurantOrderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurantOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        restaurantOrderService.addRestaurantOrder(orderCreateRequest);
    }
}