package pro.sky.collect.Depertment;

import pro.sky.collect.Employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartService {


    Employee departMaxSalary(int depart);

    Employee departMinSalary(int depart);

    Map<String, Employee> departSalary(int depart);

    Map<Integer, List<Map.Entry<String, Employee>>> departAllSalary();
}
