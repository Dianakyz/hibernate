import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/skypro",
            "postgres",
            "MASA858chu");

    public CityDAOImpl() throws SQLException {
    }

    @Override
    public void addCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City getCityById(int id_city) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id_city);
    }

    @Override
    public List<City> getAllCity() {
        List<City> cityList = (List<City>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From City").list();
        return cityList;
    }

    @Override
    public void updateCityById(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCityById(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
