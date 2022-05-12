package hu.nye.progkor.carshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.nye.progkor.carshop.model.Car;
import hu.nye.progkor.carshop.model.Fuel;
import hu.nye.progkor.carshop.model.exception.NotFoundException;

@Service
public class CarShopService {

  private static final List<Car> DATA_BASE = new ArrayList<>();

  static {
    DATA_BASE.add(new Car(1L, "Audi", "A7", 245, Fuel.PETROL));
    DATA_BASE.add(new Car(2L, "Mercedes-AMG", "GLE Coupe", 429, Fuel.HYBRID));
    DATA_BASE.add(new Car(3L, "Tesla", "Model 3", 283, Fuel.ELECTRIC));
  }

  public List<Car> findAll() {
    return DATA_BASE;
  }

  public Car load(Long id) {
    return DATA_BASE.stream().filter(car -> id.equals(car.getId())).findFirst()
        .orElseThrow(NotFoundException::new);
  }

  public Car save(Car car) {
    car.setId(getNextId());
    DATA_BASE.add(car);
    return car;
  }

  public Car update(Long id, Car carChanges) {
    return load(id).apply(carChanges);
  }

  public void delete(Long id) {
    Car car = load(id);
    DATA_BASE.remove(car);
  }

  private Long getNextId() {
    return getLastId() + 1L;
  }

  private Long getLastId() {
    return DATA_BASE.stream().mapToLong(Car::getId).max().orElse(0);
  }
}
