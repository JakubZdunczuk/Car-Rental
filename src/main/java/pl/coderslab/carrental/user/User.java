package pl.coderslab.carrental.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.carrental.validator.PasswordEqual;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 60)
    @NotNull(message = "Wpisz nazwę użytkownika")@NotEmpty(message = "Wpisz nazwę użytkownika")
    @Size(min = 3, max = 20, message = "Nazwa użytkownika powinna mieć pomiędzy 3 a 20 znaków")
    private String username;
    @NotNull(message = "Uzupełnij pole") @NotEmpty(message = "Wpisz hasło")
    @Size(min = 3, max = 60, message = "hasło powinno mieć pomiędzy 3 a 60 znaków")
    private String password;
    @NotNull(message = "wpisz email") @NotEmpty(message = "Wpisz email")
    @Email
    private String email;
    @Transient
    @NotNull(message = "wpisz ponownie hasło") @NotEmpty(message = "Wpisz ponownie hasło")
    private String passwordConfirm;
    @Transient
    private String newPassword;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
