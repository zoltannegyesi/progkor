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

    Integer hoursepower;

    Fuel fuel;

    public Car apply(Car carChanges) {
        this.brand = carChanges.getBrand();
        this.model = carChanges.getModel();
        this.hoursepower = carChanges.getHoursepower();
        this.fuel = carChanges.getFuel();
        return this;
    }
}
