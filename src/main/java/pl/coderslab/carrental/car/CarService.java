package pl.coderslab.carrental.car;

import java.util.List;

public interface CarService {

    void saveCar(Car car);

    List<Car> findByBrand(String name);
    List<Car> findByModel(String name);
    List<Car> findByGearbox(String name);
    List<Car> findByRentedFalseAndPromotion(int i);
    List<Car> findAll();
    Car findById(long id);
    void delete(Car car);

    List<Car> findAllByRentedFalse();
}

