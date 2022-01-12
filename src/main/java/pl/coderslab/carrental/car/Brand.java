package pl.coderslab.carrental.car;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Locale;

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
        return brandName;
    }

    public String getLowercase() { return brandName.toLowerCase(); }
}