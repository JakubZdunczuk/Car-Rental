package pl.coderslab.carrental.user;


import java.util.List;

public interface RentHistoryService {

    void saveHistory(RentHistory rentHistory);
    List<RentHistory> findAllByUser(User user);
    List<RentHistory> findAllByRentedTrueAndUser(User user);

    RentHistory findById(long id);
}
