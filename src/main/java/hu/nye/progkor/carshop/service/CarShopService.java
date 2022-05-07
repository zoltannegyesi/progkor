package hu.nye.progkor.carshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.nye.progkor.carshop.model.Car;
import hu.nye.progkor.carshop.model.Fuel;
import hu.nye.progkor.carshop.model.exception.NotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Service
public class CarShopService {

    private static final List<Car> DATA_BASE = new ArrayList<>();
    private final Scheduler scheduler;

    @Autowired
    public CarShopService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    static {
        DATA_BASE.add(new Car(1L, "Audi", "A7", 245, Fuel.PETROL));
        DATA_BASE.add(new Car(2L, "Mercedes-AMG", "GLE Coupe", 429, Fuel.HYBRID));
        DATA_BASE.add(new Car(3L, "Tesla", "Model 3", 283, Fuel.ELECTRIC));
    }

    public Flux<Car> findAll() {
        return Flux.defer(()->Flux.fromIterable(DATA_BASE)).subscribeOn(scheduler);
    }

    public Mono<Car> load(Long id) {
        return Mono.just(DATA_BASE.stream()
            .filter(car->id.equals(car.getId()))
            .findFirst()
            .orElseThrow(NotFoundException::new));
    }
}
