import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee1 = new Employee(1, "Ignat", "Ignatov", "male", 47, 2);
        employeeDAO.addEmployee(employee1);

        System.out.println(employeeDAO.getEmployeeById(1));

        List<Employee> list = employeeDAO.getAllEmployee();
        for(Employee employee : list) {
            System.out.println(employee);
        }

        Employee employee2 = new Employee(2, "Petr", "Petrov", "male", 24, 2);

        employeeDAO.updateEmployeeAgeById(employee2);

        employeeDAO.deleteEmployeeById(employee2);

        }
    }
