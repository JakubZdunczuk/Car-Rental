package pl.coderslab.car_longrental.car;

import java.util.List;

public interface CarService {

    List<Car> findByBrand(String name);
    List<Car> findByModel(String name);
    List<Car> findByGearbox(String name);
    List<Car> findByPromotion(int i);
    List<Car> findAll();
    Car findById(long id);
}

