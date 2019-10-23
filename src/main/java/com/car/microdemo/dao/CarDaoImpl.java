package com.car.microdemo.dao;
import com.car.microdemo.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    public static List<Car>cars=new ArrayList<>();
    static {
        cars.add(new Car(1,"Opel",3000));
        cars.add(new Car(2,"Seat",2000));
        cars.add(new Car(3,"Fiat",4000));
    }

    @Override
    public List<Car> findAll(){

        return cars;
    }

    @Override
    public Car findById(int id){
        for (Car car : cars) {
            if (car.getId()== id){
                return car;
            }
        }
        return null;
    }

    @Override
    public Car save(Car car){
        cars.add(car);
        return car;
    }

    @Override
    public Car delete(int id){
        cars.removeIf(car -> car.getId() == id );
        return null;
    }

    @Override
    public Car update(Car car){
        delete(car.getId());
        cars.add(car);
        return car;
    }
}
