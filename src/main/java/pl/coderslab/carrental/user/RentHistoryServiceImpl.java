package pl.coderslab.carrental.user;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentHistoryServiceImpl implements RentHistoryService {
    private final RentHistoryRepository rentHistoryRepository;

    public RentHistoryServiceImpl(RentHistoryRepository rentHistoryRepository) {
        this.rentHistoryRepository = rentHistoryRepository;
    }

    @Override
    public void saveHistory(RentHistory rentHistory) {
        rentHistoryRepository.save(rentHistory);
    }

    @Override
    public List<RentHistory> findAllByUser(User user) {
        return rentHistoryRepository.findAllByUser(user);
    }

    @Override
    public List<RentHistory> findAllByRentedTrueAndUser(User user) {
        return rentHistoryRepository.findAllByRentedTrueAndUser(user);
    }

    @Override
    public RentHistory findById(long id) {
        return rentHistoryRepository.getById(id);
    }
}
