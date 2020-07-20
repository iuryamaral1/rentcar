package br.com.rentcar.repositories;

import br.com.rentcar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    public Car findByLicensePlate(String licensePlate);
}
