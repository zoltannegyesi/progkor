package hu.nye.progkor.carshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

  Long id;

  String brand;

  String model;

  Integer horsepower;

  Fuel fuel;

  public Car apply(Car carChanges) {
    this.brand = carChanges.getBrand();
    this.model = carChanges.getModel();
    this.horsepower = carChanges.getHorsepower();
    this.fuel = carChanges.getFuel();
    return this;
  }
}
