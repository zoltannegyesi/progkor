package hu.nye.progkor.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.nye.progkor.carshop.model.Car;
import hu.nye.progkor.carshop.service.CarShopService;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping(value = "/car-shop")
public class CarShopController {
    
    private final CarShopService carShopService;

    @Autowired
    public CarShopController(CarShopService carShopService) {
        this.carShopService = carShopService;
    }

    @GetMapping
    public String findAll(Model model) {
        Flux<Car> cars = this.carShopService.findAll();
        model.addAttribute("cars", cars);
        return "carshop/list";
    }
}
