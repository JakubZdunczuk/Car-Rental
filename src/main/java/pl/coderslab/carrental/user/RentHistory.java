package pl.coderslab.carrental.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.carrental.car.Car;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class RentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @NotNull
    private Car car;
    @ManyToOne
    @NotNull
    private User user;
    @Max(7)
    private int days;
    @Max(12)
    private int months;
    @Column(columnDefinition = "DATE")
    private LocalDate rentDay;
    private boolean rented=true;
}
