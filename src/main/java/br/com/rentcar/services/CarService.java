package br.com.rentcar.services;

import br.com.rentcar.model.Car;
import br.com.rentcar.repositories.CarRepository;

public class CarService extends AbstractService<Car, CarRepository> {

    public Car findByLicensePlate(String licensePlate) {
        return repository.findByLicensePlate(licensePlate);
    }
}
