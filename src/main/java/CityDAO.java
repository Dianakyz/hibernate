import java.util.List;

public interface CityDAO {
    void addCity(City city);

    City getCityById(int id_city);

    List<City> getAllCity();

    void updateCityById(City city);

    void deleteCityById(City city);
}
