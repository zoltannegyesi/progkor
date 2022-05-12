package hu.nye.progkor.carshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hu.nye.progkor.carshop.model.Car;
import hu.nye.progkor.carshop.model.Fuel;
import hu.nye.progkor.carshop.model.exception.NotFoundException;

public class CarShopServiceTest {

  private static final Car AUDI = new Car(1L, "Audi", "A7", 245, Fuel.PETROL);
  private static final Car MERCEDES = new Car(2L, "Mercedes-AMG", "GLE Coupe", 429, Fuel.HYBRID);
  private static final Car TESLA = new Car(3L, "Tesla", "Model 3", 283, Fuel.ELECTRIC);

  private static final List<Car> CARS = List.of(AUDI, MERCEDES, TESLA);

  public static final long UNKNOWN_CAR_ID = -1L;

  private CarShopService underTest;

  @BeforeEach
  void setUp() {
    underTest = new CarShopService(CARS);
  }

  @Test
  void createCarShopServiceObjectWithoutParametersShouldReturnDataBaseWithThreeCars() {
    // given
    underTest = new CarShopService();
    // when
    List<Car> actual = underTest.findAll();
    // then
    assertEquals(CARS, actual);
  }

  @Test
  void getAllCarsShouldReturnAllCars() {
    // when
    final List<Car> actual = underTest.findAll();
    // then
    assertEquals(actual, CARS);
  }

  @Test
  void getCarShouldReturnCarWithExistingId() {
    // when
    Car actual = underTest.load(AUDI.getId());
    // then
    assertEquals(AUDI, actual);
  }

  @Test
  void getCarShouldThrowNotFoundExceptionWithNonExistingId() {
    // when then
    assertThrows(NotFoundException.class, () -> underTest.load(UNKNOWN_CAR_ID));
  }

  @Test
  void createCarShouldReturnCarWhenItIsCreated() {
    // given
    Car Bmw = new Car(null, "BMW", "M5 Sedan", 617, Fuel.PETROL);
    Car expectedBmw = new Car(4L, "BMW", "M5 Sedan", 617, Fuel.PETROL);
    // when
    Car actual = underTest.save(Bmw);
    // then
    assertEquals(expectedBmw, actual);
  }

  @Test
  void updateCarShouldReturnUpdatedRolePlayWhenGivenExistingCarWithId() {
    // given
    Car Bmw = new Car(null, "BMW", "M5 Sedan", 617, Fuel.PETROL);
    Car expectedBmw = new Car(MERCEDES.getId(), "BMW", "M5 Sedan", 617, Fuel.PETROL);
    // when
    final Car actual = underTest.update(MERCEDES.getId(), Bmw);
    // then
    assertEquals(expectedBmw, actual);
  }

  @Test
  void updateCarShouldThrowNotFoundExceptionWhenGivenNonExistingCarWithId() {
	// given
  Car Bmw = new Car(null, "BMW", "M5 Sedan", 617, Fuel.PETROL);
  // when then
    assertThrows(NotFoundException.class, () -> underTest.update(UNKNOWN_CAR_ID, Bmw));
  }

  @Test
  void deleteCarShouldDeleteCarWithGivenId() {
    // given
    List<Car> expectedCars = List.of(AUDI, MERCEDES);
    // when
    underTest.delete(TESLA.getId());
    List<Car> actual = underTest.findAll();
    // then
    assertEquals(expectedCars, actual);
  }

}
