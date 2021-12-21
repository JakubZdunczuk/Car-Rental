package pl.coderslab.car_longrental.car;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findByBrand(String name) {
        return null;
    }

    @Override
    public List<Car> findByModel(String name) {
        return null;
    }

    @Override
    public List<Car> findByGearbox(String name) {
        return null;
    }

    @Override
    public List<Car> findByPromotion(int i) {
        return carRepository.findByPromotion(1);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(long id) {
        return carRepository.findById(id);
    }
}
