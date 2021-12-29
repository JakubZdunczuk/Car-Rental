package pl.coderslab.carrental.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cars")
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String carBody;
    private String gearbox;
    private String engine;
    private String fuel;
    private String colour;
    private String productionYear;
    private long price;
    private String specification;
    private int promotion;

@ManyToOne
    private CarModel model;
}
