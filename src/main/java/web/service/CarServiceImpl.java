package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars(int cars) {
        return carDao.getCars(cars);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }
}
