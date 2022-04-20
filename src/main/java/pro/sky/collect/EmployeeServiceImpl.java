package pro.sky.collect;

import org.springframework.stereotype.Service;
import pro.sky.collect.Exception.AddExceptionBadReques;
import pro.sky.collect.Exception.FindException;
import pro.sky.collect.Exception.RemoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employee = new ArrayList<>(List.of(
            new Employee("Lex", "Lutor"),
            new Employee("Clark", "Kent"),
            new Employee("Lois", "Laine"),
            new Employee("Oliver", "Queen"),
            new Employee("Viktor", "Stone")
    ));

    HashMap<String, Employee> mapEmploye = new HashMap<>();

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
    public Employee add(String name, String lastName) {
        if (mapEmploye.containsKey(name + lastName)) throw new AddExceptionBadReques();
        mapEmploye.put(name + lastName, new Employee(name, lastName));
        return mapEmploye.get(name + lastName);

    }

    @Override
    public HashMap<String, Employee> mapListEmployee() {
        return mapEmploye;
    }

}