package hu.nye.progkor.carshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hu.nye.progkor.carshop.model.Car;
import hu.nye.progkor.carshop.model.Fuel;

public class CarShopServiceTest {

  private static final Car AUDI = new Car(1L, "Audi", "A7", 245, Fuel.PETROL);
  private static final Car MERCEDES = new Car(2L, "Mercedes-AMG", "GLE Coupe", 429, Fuel.HYBRID);
  private static final Car TESLA = new Car(3L, "Tesla", "Model 3", 283, Fuel.ELECTRIC);

  private static final List<Car> CARS = List.of(
          AUDI,
          MERCEDES,
          TESLA
  );

  private CarShopService underTest;

  @BeforeEach
  void setUp() {
    underTest = new CarShopService(CARS);
  }

  @Test
  void getAllCarsShouldReturnAllCars() {
    // when
    final List<Car> actual = underTest.findAll();
    // then
    assertEquals(actual, CARS);
  }
  
}
