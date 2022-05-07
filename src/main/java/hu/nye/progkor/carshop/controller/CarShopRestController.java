package hu.nye.progkor.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.nye.progkor.carshop.service.CarShopService;

@RestController
@RequestMapping("/api/v1/car-shop")
public class CarShopRestController {
    
    private final CarShopService carShopService;

    @Autowired
    public CarShopRestController(CarShopService carService) {
        this.carService = carService;
    }
}
