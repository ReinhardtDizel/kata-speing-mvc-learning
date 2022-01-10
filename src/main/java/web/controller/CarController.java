package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String carPage(
            @RequestParam(name = "count", required = false) Integer count,
            ModelMap model) {

        List<String> messages = new ArrayList<>();
        carService.getCars(count).forEach(car -> messages.add(car.toString()));
        model.addAttribute("messages", messages);
        return "cars";
    }
}