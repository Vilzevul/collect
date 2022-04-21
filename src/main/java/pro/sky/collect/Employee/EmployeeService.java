package pro.sky.collect.Employee;

import java.util.HashMap;
import java.util.OptionalDouble;

public interface EmployeeService {
    Employee find(String name, String lastName);

    Employee remove(String name, String lastName);

    void initMap();

    Employee add(String name, String lastName, int unit, double salary);

    HashMap<String, Employee> mapListEmployee();

    HashMap<String, Employee> mapEmployee();

    double summa();

    OptionalDouble maxValue();

    OptionalDouble minValue();

    double midlValue();

}
