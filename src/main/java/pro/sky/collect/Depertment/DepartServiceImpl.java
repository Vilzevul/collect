package pro.sky.collect.Depertment;

import org.springframework.stereotype.Service;
import pro.sky.collect.Employee.Employee;
import pro.sky.collect.Employee.EmployeeService;
import pro.sky.collect.Exception.BadParamsException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartServiceImpl implements DepartService {

    private final EmployeeService employeeService;

    public DepartServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee departMaxSalary(int depart) {
        Employee employee = employeeService.mapEmployee().values().stream()
                .filter(v -> v.getUnit() == depart)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(BadParamsException::new);;
        return employee;
    }


    @Override
    public Employee departMinSalary(int depart) {
        Employee employee = employeeService.mapEmployee().values().stream()
                .filter(v -> v.getUnit() == depart)
 //               .min(Comparator.comparingDouble(Employee::getSalary)).get()
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(BadParamsException::new);
        return employee;

    }

    @Override
    public Map<String, Employee> departSalary(int depart) {
        return employeeService.mapEmployee().entrySet().stream()
                .filter(v -> v.getValue().getUnit() == depart)
                //                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    @Override
    public Map<Integer, List< Employee>> departAllSalary() {
        return employeeService.mapEmployee().values().stream()
 //               .collect(Collectors.groupingBy(x -> x.getValue().getUnit()));
                .collect(Collectors.groupingBy(Employee::getUnit));

    }

}