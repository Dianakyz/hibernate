import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue
    private int city_id;
    @Column(name = "name_city")
    private String name_city;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    public City() {
    }

    public City(int city_id, String name_city) {
        this.city_id = city_id;
        this.name_city = name_city;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getName_city() {
        return name_city;
    }

    public void setName_city(String name_city) {
        this.name_city = name_city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return city_id == city.city_id && Objects.equals(name_city, city.name_city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_id, name_city);
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", name_city='" + name_city + '\'' +
                '}';
    }
}
