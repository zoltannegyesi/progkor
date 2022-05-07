package hu.nye.progkor.carshop;

import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class CarshopApplication {

	private static final int CONNECTION_POOL_SIZE = 100;

	public static void main(String[] args) {
		SpringApplication.run(CarshopApplication.class, args);
	}

	@Bean
	public Scheduler scheduler() {
		return Schedulers.fromExecutor(Executors.newFixedThreadPool(CONNECTION_POOL_SIZE));
	}
}
