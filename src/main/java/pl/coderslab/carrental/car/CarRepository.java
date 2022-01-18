package pl.coderslab.carrental.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findById(long id);

    List<Car> findAll();

    List<Car> findByRentedFalseAndPromotion(int i);

    List<Car> findAllByRentedFalse();
}
