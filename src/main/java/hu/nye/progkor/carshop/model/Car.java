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

    Integer displacement;

    Integer hoursepower;

    Fuel fuel;
}
