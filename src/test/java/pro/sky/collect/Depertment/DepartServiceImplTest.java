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
import pro.sky.collect.Exception.BadParamsException;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartServiceImplTest {
    private static final String NAME1 = "Clark";
    private static final String NAME2 = "Lex";
    private static final String LASTNAME1 = "Kent";
    private static final String LASTNAME2 = "Lutor";
    private static final int MAXSALARY = 20;
    private static final int MINSALARY = 10;

    private static final Employee RESULT = new Employee(NAME1, LASTNAME1, 1, MAXSALARY);
    private static final Employee RESULT2 = new Employee(NAME2, LASTNAME2, 1, MINSALARY);

    private final List<Employee> collectResult = List.of(
             RESULT,RESULT2);

    private static final Set<Employee> DEPEMPLOYEE = Set.of(RESULT, RESULT2);
    private static final Map<Integer, List<Employee>> MAP = DEPEMPLOYEE.stream()
            .collect(Collectors.groupingBy(Employee::getUnit));

   private HashMap<String, Employee> map = new HashMap<>();

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
        when((employeeService.mapEmployee())).thenReturn(map);
        assertEquals(RESULT, out.departMaxSalary(1));
    }

    @Test
    public void testMaxThrows() {
        when((employeeService.mapEmployee())).thenReturn(map);
        assertThrows(BadParamsException.class, () -> out.departMaxSalary(10));
    }

    @Test
    public void testMin() {
        when((employeeService.mapEmployee())).thenReturn(map);
        assertEquals(RESULT2, out.departMinSalary(1));
    }

    @Test
    public void testMinThrows() {
        when((employeeService.mapEmployee())).thenReturn(map);
        assertThrows(BadParamsException.class, () -> out.departMinSalary(10));
    }


    @Test
    public void testDepartSalary() {
        when((employeeService.mapEmployee())).thenReturn(map);
        assertEquals(map, out.departSalary(1));
    }



    @Test
    public void testDepartAllSalary() {
        when((employeeService.mapEmployee())).thenReturn(map);
        assertEquals(MAP, out.departAllSalary());
    }


}
