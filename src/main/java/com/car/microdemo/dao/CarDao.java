package com.car.microdemo.dao;
import com.car.microdemo.model.Car;
import java.util.List;

public interface CarDao {
    public List<Car> findAll();
    public Car findById(int id);
    public Car save(Car car);
}
