import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City chita = new City(6, "Chita");
        cityDAO.addCity(chita);
        City orel = new City(7, "Orel");
        cityDAO.addCity(orel);

        Employee employee1 = new Employee(1, "Ignat", "Ignatov", "male", 47, chita);
        employeeDAO.addEmployee(employee1);

        System.out.println(employeeDAO.getEmployeeById(1));
        System.out.println(cityDAO.getCityById(8));

        List<Employee> list = employeeDAO.getAllEmployee();
        for(Employee employee : list) {
            System.out.println(employee);
        }

        List<City> cityList = cityDAO.getAllCity();
        for(City city : cityList) {
            System.out.println(city);
        }

        Employee employee2 = new Employee(2, "Petr", "Petrov", "male", 24, orel);

        employeeDAO.updateEmployeeAgeById(employee2);

        employeeDAO.deleteEmployeeById(employee1);

        }
    }
