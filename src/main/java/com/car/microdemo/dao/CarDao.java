package com.car.microdemo.dao;
import com.car.microdemo.model.Car;
import java.util.List;

public interface CarDao {
    List<Car> findAll();
    Car findById(int id);
    Car save(Car car);
    Car delete(int id);
    Car update(Car car);
}
