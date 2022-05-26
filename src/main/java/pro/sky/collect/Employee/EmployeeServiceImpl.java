package pro.sky.collect.Employee;

import org.springframework.stereotype.Service;
import pro.sky.collect.Exception.AddExceptionBadReques;
import pro.sky.collect.Exception.FindException;
import pro.sky.collect.Exception.RemoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employee = new ArrayList<>(List.of(
            new Employee("Clark", "Kent", 1, 20),
            new Employee("Lex", "Lutor", 1, 10),
            new Employee("Lois", "Laine", 2, 10),
            new Employee("Oliver", "Queen", 2, 50),
            new Employee("Viktor", "Stone", 3, 30)
    ));

    public HashMap<String, Employee> mapEmploye = new HashMap<>();

    //Заполнили мапу
    @Override
    public void initMap() {
        for (Employee emp : employee) {
            mapEmploye.put(emp.getName() + emp.getLastName(), emp);
        }
    }


    @Override
    public Employee find(String name, String lastName) {

        if (mapEmploye.containsKey(name + lastName))
            return mapEmploye.get(name + lastName);
        throw new FindException();
    }

    @Override
    public Employee remove(String name, String lastName) {
        if (mapEmploye.containsKey(name + lastName))
            return mapEmploye.remove(name + lastName);
        throw new RemoveException();
    }


    @Override
    public Employee add(String name, String lastName, int unit, double salary) {
        if (mapEmploye.containsKey(name + lastName)) throw new AddExceptionBadReques();
        mapEmploye.put(name + lastName, new Employee(name, lastName, unit, salary));
        return mapEmploye.get(name + lastName);

    }

    //Список
    @Override
    public HashMap<String, Employee> mapListEmployee() {
        return mapEmploye;
    }

    @Override
    public HashMap<String, Employee> mapEmployee() {
        return mapEmploye;
    }

    //сумма
    @Override
    public double summa() {
        double vDouble = mapEmploye.values().stream()
                .mapToDouble(value -> value.getSalary()).sum();

/*        List vList = mapEmploye.values().stream()
                .map(v -> v.getSalary())
                .collect(Collectors.toList());
        vDouble = vList.stream().mapToDouble(d -> (Double) d).sum();


        List<Integer> iList = mapEmploye.values().stream()
                .map(v -> v.getUnit())
                .collect(Collectors.toList());
        Optional<Integer> vInt = iList.stream().reduce(Integer::sum);
        vInt.ifPresent(System.out::println);
        double dList = mapEmploye.values().stream()
                .map(Employee::getSalary)
                .collect(Collectors.toList())
                .stream().mapToDouble(d -> (double) d)
                .sum();
*/
        return vDouble;
    }


    //max
    @Override
    public OptionalDouble maxValue() {
        return mapEmploye.values().stream()
                .mapToDouble(value -> value.getSalary()).max();
    }

    //min
    @Override
    public OptionalDouble minValue() {
        return mapEmploye.values().stream()
                .mapToDouble(value -> value.getSalary()).min();
    }

    //Средняя
    @Override
    public double midlValue() {
        return summa() / mapEmploye.size();

    }


}






