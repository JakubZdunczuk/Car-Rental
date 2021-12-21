package pl.coderslab.car_longrental.car;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brandName;

    @Override
    public String toString() {
        return brandName.toLowerCase();
    }
}