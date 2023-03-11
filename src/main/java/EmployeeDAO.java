import java.util.List;

public interface EmployeeDAO {

    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    void updateEmployeeAgeById(Employee employee);

    void deleteEmployeeById(Employee employee);
}
