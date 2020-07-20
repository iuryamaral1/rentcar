package br.com.rentcar.resources;

import br.com.rentcar.dto.InputCarDto;
import br.com.rentcar.dto.OutputCarDto;
import br.com.rentcar.mappers.CarMapper;
import br.com.rentcar.model.Car;
import br.com.rentcar.services.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarResource extends AbstractResource<Car, InputCarDto, OutputCarDto, CarMapper, CarService> {
    @Override
    protected Class<Car> getEntityClass() {
        return Car.class;
    }
}
