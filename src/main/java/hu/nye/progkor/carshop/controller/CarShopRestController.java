package hu.nye.progkor.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "/{id}/edit")
    public Mono<Car> load(@PathVariable("id") Long id) {
        return this.carShopService.load(id);
    }

    @PostMapping(value = "/create")
    public Mono<Car> save(@RequestBody Car car) {
        return this.carShopService.save(car);
    }

    @PutMapping(value = "/{id}/edit")
    public Mono<Car> update(@PathVariable("id") Long id, @RequestBody Car carChanges) {
        return this.carShopService.update(id, carChanges);
    }

    @DeleteMapping(value = "{id}/edit")
    public ResponseEntity<Void> delete(Long id) {
        this.carShopService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
