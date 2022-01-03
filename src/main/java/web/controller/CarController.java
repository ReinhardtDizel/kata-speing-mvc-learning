package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDaoCSV;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService = new CarServiceImpl(new CarDaoCSV());

    @GetMapping()
    public String carPage(
            @RequestParam Optional<Integer> count,
            ModelMap model
    ) {
        List<String> messages = new ArrayList<>();
        if (count.isPresent()) {
            carService.getCars(count.get()).forEach(car -> messages.add(car.toString()));
        } else {
            carService.getAllCars().forEach(car -> messages.add(car.toString()));
        }
        model.addAttribute("messages", messages);
        return "cars";
    }
}