package pl.coderslab.carrental.car;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarModelServiceImpl implements CarModelService {
    private final CarModelRepository carModelRepository;

    public CarModelServiceImpl(CarModelRepository carModelRepository) {
        this.carModelRepository = carModelRepository;
    }

    @Override
    public void saveCarModel(CarModel carModel){carModelRepository.save(carModel);}

        public CarModel findById(long id){
        return carModelRepository.findById(id);
        }

        public List<CarModel> findAll(){
        return carModelRepository.findAll();
        }
}
