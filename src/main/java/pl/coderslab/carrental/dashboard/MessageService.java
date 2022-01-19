package pl.coderslab.carrental.dashboard;

import pl.coderslab.carrental.user.User;

import java.util.List;

public interface MessageService {
    void saveMessage(Message message);

    void deleteMessage(Message message);

    List<Message> findAll();

    Message findById(long id);

    List<Message> findAllByUser(User user);
}
