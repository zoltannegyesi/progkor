package hu.nye.progkor.carshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.nye.progkor.carshop.model.Car;
import hu.nye.progkor.carshop.model.Fuel;
import reactor.core.scheduler.Scheduler;

@Service
public class CarService {

    private static final List<Car> DATA_BASE = new ArrayList<>();
    private final Scheduler scheduler;

    @Autowired
    public CarService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    static {
        DATA_BASE.add(new Car(1L, "Audi", "A7", 245, Fuel.PETROL));
        DATA_BASE.add(new Car(2L, "Mercedes-AMG", "GLE Coupe", 429, Fuel.HYBRID));
        DATA_BASE.add(new Car(3L, "Tesla", "Model 3", 283, Fuel.ELECTRIC));
    }

    


    
}
