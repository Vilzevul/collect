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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartServiceImplTest {
final String NAME1 = "Clark";
final String NAME2 = "Lex";
final String LASTNAME1 = "Kent";
final String LASTNAME2 = "Lutor";
final int MAXSALARY = 20;
final int MINSALARY = 10;

    final Employee RESULT = new Employee(NAME1, LASTNAME1, 1, MAXSALARY);
    final Employee RESULT2 = new Employee(NAME2, LASTNAME2, 1, MINSALARY);

    List<Employee> collectResult = new ArrayList<>(List.of(
            new Employee(NAME2, LASTNAME2, 1, MINSALARY),
            new Employee(NAME1, LASTNAME1, 1, MAXSALARY)));

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
        assertEquals(RESULT, out.departMaxSalary(1));
    }
    @Test
    public void testMaxThrows() {
        when( (employeeService.mapEmployee())).thenReturn( map);
        assertThrows(BadParamsException.class,()->out.departMaxSalary(10) );
    }

    @Test
    public void testMin() {
        when( (employeeService.mapEmployee())).thenReturn( map);
        assertEquals(RESULT2, out.departMinSalary(1));
            }
    @Test
    public void testMinThrows() {
        when( (employeeService.mapEmployee())).thenReturn( map);
        assertThrows(BadParamsException.class,()->out.departMinSalary(10) );
    }


    @Test
    public void testDepartSalary() {
        when( (employeeService.mapEmployee())).thenReturn( map);
        assertEquals(map, out.departSalary(1));
    }
    @Test
    public void testDepartAllSalary() {
        when( (employeeService.mapEmployee())).thenReturn( map);
        assertNotNull(out.departAllSalary());
    }


}
