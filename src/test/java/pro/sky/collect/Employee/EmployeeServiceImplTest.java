package pro.sky.collect.Employee;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import pro.sky.collect.Exception.AddExceptionBadReques;
import pro.sky.collect.Exception.FindException;
import pro.sky.collect.Exception.RemoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    EmployeeServiceImpl out = new EmployeeServiceImpl();

    @BeforeEach
    public void initTest() {
        out.initMap();
        System.out.println("@Before");
    }

    @AfterEach
    public void endTest() {
        System.out.println("@After");
    }

    @Test
    public void testFind() throws Exception {
        System.out.println("@Test");
        Employee result = out.add("Name2", "Last2", 1, 10);
        assertEquals(result, out.find("Name2", "Last2"));
        assertThrows(FindException.class, () -> out.find("Name22", "Last22"));
    }

    @Test
    public void testRemove() {
        Employee result = out.find("Clark", "Kent");
        assertEquals(result, out.remove("Clark", "Kent"));
    }

    @Test
    public void testRemoveContains() {
        if (!out.mapEmployee().containsKey("name" + "lastName"))
            assertThrows(RemoveException.class, () -> out.remove("name", "lastName"));

    }

    @Test
    public void testAdd() throws Exception {
        Employee result = new Employee("Name11", "Last11", 1, 10);
        assertFalse(out.mapEmployee().containsKey(result.getName() + result.getLastName()));

        assertThrows(AddExceptionBadReques.class, () -> out.add("Clark", "Kent", 1, 10));
    }

    @Test
    public void testSumma() {
        assertEquals(120d, out.summa());
    }

    @Test
    public void testMaxMin() {
        assertEquals(OptionalDouble.of(50d), out.maxValue());
        assertEquals(OptionalDouble.of(10d), out.minValue());
        assertEquals(24d, out.midlValue());

    }
}
