package com.car.microdemo.web.controller;

import com.car.microdemo.CarForm;
import com.car.microdemo.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.car.microdemo.dao.CarDaoImpl.cars;


@Controller
public class CarController {

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = "/Cars", method = RequestMethod.GET)
    public String carList(Model model) {
        model.addAttribute("cars", cars);
        return "carList";
    }

    @RequestMapping(value = {"/addCar"}, method = RequestMethod.GET)
    public String addList(Model model) {
        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);
        return "addCar";
    }


    @RequestMapping(value = {"/addCar"}, method = RequestMethod.POST)
    public String saveCar(Model model,
                             @ModelAttribute("carForm") CarForm carForm) {

        int id = carForm.getId();
        String nom = carForm.getNom();
        int price = carForm.getPrice();

        if (nom != null && nom.length() > 0 //
                && price != 0) {
            Car newCar = new Car(id,nom, price);
            cars.add(newCar);

            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }
}
