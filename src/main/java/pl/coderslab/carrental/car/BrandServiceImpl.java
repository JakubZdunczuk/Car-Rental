package pl.coderslab.carrental.car;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAllByOrderByBrandNameAsc();
    }

    @Override
    public Brand findById(long id) {
        return brandRepository.findById(id);
    }
}
