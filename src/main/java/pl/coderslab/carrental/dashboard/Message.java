package pl.coderslab.carrental.dashboard;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.carrental.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String subject;
    @NotNull
    private String content;
    private boolean isRead;

    @ManyToOne
    private User user;
}
