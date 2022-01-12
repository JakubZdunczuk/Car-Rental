package pl.coderslab.carrental.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

CarModel findById(long id);
List<CarModel> findByBrandId(long id);
}
