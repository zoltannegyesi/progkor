package hu.nye.progkor.carshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.nye.progkor.carshop.model.Car;
import hu.nye.progkor.carshop.model.Fuel;
import hu.nye.progkor.carshop.model.exception.NotFoundException;

@Service
public class CarShopService {

  private final List<Car> dataBase = new ArrayList<>();


  public CarShopService() {
    dataBase.add(new Car(1L, "Audi", "A7", 245, Fuel.PETROL));
    dataBase.add(new Car(2L, "Mercedes-AMG", "GLE Coupe", 429, Fuel.HYBRID));
    dataBase.add(new Car(3L, "Tesla", "Model 3", 283, Fuel.ELECTRIC));
  }

  public CarShopService(List<Car> cars) {
    dataBase.addAll(cars);
  }

  public List<Car> findAll() {
    return dataBase;
  }

  public Car load(Long id) {
    return dataBase.stream().filter(car -> id.equals(car.getId())).findFirst()
        .orElseThrow(NotFoundException::new);
  }

  public Car save(Car car) {
    car.setId(getNextId());
    dataBase.add(car);
    return car;
  }

  public Car update(Long id, Car carChanges) {
    return load(id).apply(carChanges);
  }

  public void delete(Long id) {
    Car car = load(id);
    dataBase.remove(car);
  }

  private Long getNextId() {
    return getLastId() + 1L;
  }

  private Long getLastId() {
    return dataBase.stream().mapToLong(Car::getId).max().orElse(0);
  }
}
