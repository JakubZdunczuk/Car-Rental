package pl.coderslab.carrental.car;

import java.util.List;

public interface BrandService {

    void saveBrand(Brand brand);

    List<Brand> findAll();
    Brand findById(long id);
}