package pl.coderslab.carrental.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;


@Getter
@Setter
@Entity
@Table(name = "cars")
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "{car.notempty}")
    @NotEmpty(message = "{car.notempty}")
    private String carBody;
    @NotNull(message = "{car.notempty}")
    @NotEmpty(message = "{car.notempty}")
    private String gearbox;
    @NotNull(message = "{car.notempty}")
    @NotEmpty(message = "{car.notempty}")
    private String engine;
    @NotNull(message = "{car.notempty}")
    @NotEmpty(message = "{car.notempty}")
    private String fuel;
    @NotNull(message = "{car.notempty}")
    @NotEmpty(message = "{car.notempty}")
    private String colour;
    @NotNull(message = "{car.notempty}")
    private int productionYear;
    @NotNull(message = "{car.notempty}")
    private long price;
    @NotNull(message = "{car.notempty}")
    @NotEmpty(message = "{car.notempty}")
    private String specification;
    private int promotion;
    private boolean rented = false;

    @ManyToOne
    @NotNull(message = "{car.notempty}")
    private CarModel model;
}
