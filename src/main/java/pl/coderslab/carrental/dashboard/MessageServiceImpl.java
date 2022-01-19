package pl.coderslab.carrental.dashboard;

import org.springframework.stereotype.Service;
import pl.coderslab.carrental.user.User;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    public final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void saveMessage(Message message) {
        message.setRead(false);
        messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Message message) {
        messageRepository.delete(message);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findById(long id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> findAllByUser(User user) {
        return messageRepository.findAllByUser(user);
    }
}
