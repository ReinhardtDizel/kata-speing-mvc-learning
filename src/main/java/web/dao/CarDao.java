package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.List;

@Component
public interface CarDao {
    List<Car> getAllCars();

    List<Car> getCars(int cars);
}
