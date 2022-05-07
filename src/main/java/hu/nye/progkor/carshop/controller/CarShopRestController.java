package hu.nye.progkor.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.nye.progkor.carshop.model.Car;
import hu.nye.progkor.carshop.service.CarShopService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/v1/car-shop")
public class CarShopRestController {
    
    private final CarShopService carShopService;

    @Autowired
    public CarShopRestController(CarShopService carShopService) {
        this.carShopService = carShopService;
    }

    @GetMapping(value = "/list")
    public Flux<Car> findAll() {
        return this.carShopService.findAll();
    }

    @GetMapping(value = "/edit/{id}")
    public Mono<Car> load(@PathVariable("id") Long id) {
        return this.carShopService.load(id);
    }
}
