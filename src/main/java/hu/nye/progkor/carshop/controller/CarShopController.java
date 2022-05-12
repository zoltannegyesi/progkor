package hu.nye.progkor.carshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.nye.progkor.carshop.model.Car;
import hu.nye.progkor.carshop.model.exception.NotFoundException;
import hu.nye.progkor.carshop.service.CarShopService;
@Controller
@RequestMapping(value = "/car-shop")
public class CarShopController {
    
    private final CarShopService carShopService;

    @Autowired
    public CarShopController(CarShopService carShopService) {
        this.carShopService = carShopService;
    }

    @GetMapping
    public String findAll(final Model model) {
        List<Car> cars = this.carShopService.findAll();
        model.addAttribute("cars", cars);
        return "carshop/list";
    }

    @GetMapping(value = "/{id}")
    public String load(@PathVariable Long id ,final Model model) {
        Car car = this.carShopService.load(id);
        model.addAttribute("car", car);
        return "carshop/edit";
    }

    @GetMapping("/create")
    public String createForm(final Model model) {
        return "carshop/create";
    }

    @PostMapping("/create")
    public String createRolePlay(final Model model, final Car car) {
        this.carShopService.save(car);
        List<Car> cars = this.carShopService.findAll();
        model.addAttribute("cars", cars);
        return "carshop/list";
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String update(final Model model,
                               @RequestParam(value = "id", required = false) Long id,
                               final Car carChanges) {
    final Car car = this.carShopService.update(id, carChanges);                               
    model.addAttribute("car", car);
    return findAll(model);
  }

  @GetMapping("/{id}/delete")
  public String delete(final @PathVariable("id") Long id, final Model model) {
    try {
      this.carShopService.delete(id);
    } catch (NotFoundException e) {
      // Ignored
    }
    return findAll(model);
  }
}
