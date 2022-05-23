package pro.sky.collect.Depertment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.collect.Employee.EmployeeService;
import pro.sky.collect.Employee.EmployeeServiceImpl;
import pro.sky.collect.Employee.EmployeeServiceImplTest;
import pro.sky.collect.Employee.Employee;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartServiceImplTest {

    Employee result = new Employee("Clark", "Kent", 1, 20);
    Employee result2 = new Employee("Lex", "Lutor", 1, 10);

    List<Employee> collectResult = new ArrayList<>(List.of(
            new Employee("Lex", "Lutor", 1, 10),
            new Employee("Clark", "Kent", 1, 20)));

    HashMap<String, Employee> map = new HashMap<>();

    //Заполнили мапу
    @BeforeEach
    public void initMap() {
        for (Employee emp : collectResult) {
            map.put(emp.getName() + emp.getLastName(), emp);
        }
    }
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartServiceImpl out;

    @Test
    public void testMax() {
        when( (employeeService.mapEmployee())).thenReturn( map);
        assertEquals(result, out.departMaxSalary(1));
    }

    @Test
    public void testMin() {
        when( (employeeService.mapEmployee())).thenReturn( map);
        assertEquals(result2, out.departMinSalary(1));
    }
    @Test
    public void testDepartSalary() {
        when( (employeeService.mapEmployee())).thenReturn( map);
        assertEquals(map, out.departSalary(1));
    }
    @Test
    public void testDepartAllSalary() {
        when( (employeeService.mapEmployee())).thenReturn( map);
        assertEquals(map, out.departAllSalary());
    }


}
