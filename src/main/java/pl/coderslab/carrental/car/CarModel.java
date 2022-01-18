package pl.coderslab.carrental.car;

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
    @ManyToOne
    private Brand brand;

    @Override
    public String toString() {
        return brand + " " + modelName;
    }
}
