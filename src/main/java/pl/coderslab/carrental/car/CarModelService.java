package pl.coderslab.carrental.car;

import java.util.List;

public interface CarModelService {

    void saveCarModel(CarModel carModel);
    CarModel findById(long id);
    List<CarModel> findAll();
}
