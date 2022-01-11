package pl.coderslab.carrental.car;

import java.util.List;

public interface BrandService {

    List<Brand> findAll();
    Brand findById(long id);
}