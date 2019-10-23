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
    public Car saveCar(@RequestBody Car car) {
        return CarDao.save(car);
    }


    @PutMapping(value = "/Cars")
    public Car updateCar(@RequestBody Car car) {
        return CarDao.update(car);
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
