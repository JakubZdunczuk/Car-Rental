package pl.coderslab.carrental.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findById(long id);

    List<Brand> findAllByOrderByBrandNameAsc();

}
