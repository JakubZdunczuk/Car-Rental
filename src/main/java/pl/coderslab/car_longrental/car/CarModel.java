package pl.coderslab.car_longrental.car;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "models")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String modelName;
    private String generation;
    @ManyToOne
    private Brand brand;

    @Override
    public String toString() {
        return brand + " " + modelName + ", generacja: " + generation;
    }
}