package com.car.microdemo.web.controller;

import com.car.microdemo.dao.CarDao;
import com.car.microdemo.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
public class CarController {



    @Autowired
    private CarDao CarDao;

    @RequestMapping(value = "/Cars", method = RequestMethod.GET)
    public List<Car> carList() {
        return CarDao.findAll();
    }

    @PostMapping(value = "/Cars")
    public ResponseEntity<Void> saveCar(@RequestBody Car car) {
        Car saveCar = CarDao.save(car);
        if (saveCar == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveCar.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/Cars")
    public ResponseEntity<Void> updateCar(@RequestBody Car car) {
        Car updateCar = CarDao.update(car);
        if (updateCar == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updateCar.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/Cars/{id}")
    public Car deleteCar(@PathVariable int id) {
        return CarDao.delete(id);
    }

    @GetMapping(value = "/Cars/{id}")
    public Car showCar(@PathVariable int id) {
        return CarDao.findById(id);
    }

}
