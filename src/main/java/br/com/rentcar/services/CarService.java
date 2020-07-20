package br.com.rentcar.services;

import br.com.rentcar.model.Car;
import br.com.rentcar.repositories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService extends AbstractService<Car, CarRepository> {

    public Car findByLicensePlate(String licensePlate) {
        return repository.findByLicensePlate(licensePlate);
    }
}
