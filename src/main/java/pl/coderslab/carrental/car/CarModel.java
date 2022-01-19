package pl.coderslab.carrental.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "models")
@NoArgsConstructor
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String modelName;
    @ManyToOne
    private Brand brand;

    public CarModel(String modelName, Brand brand) {
        this.modelName = modelName;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return brand + " " + modelName;
    }
}
