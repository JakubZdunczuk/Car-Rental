package pl.coderslab.carrental.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentHistoryRepository extends JpaRepository<RentHistory, Long> {

    List<RentHistory> findAllByUser(User user);

    List<RentHistory> findAllByRentedTrueAndUser(User user);

    RentHistory findById(long id);
}

