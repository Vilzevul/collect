package pro.sky.collect.Depertment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collect.Employee.Employee;
import pro.sky.collect.Exception.BadParamsException;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/departments")

@RestController
public class DepartController {
    private final DepartService departService;

    public DepartController(DepartService departService) {
        this.departService = departService;
    }


    @GetMapping(path = "/max-salary")
    public Employee departMaxSalary(@RequestParam(value = "departmentId", required = false) int departmentId) {
        if (departmentId <= 0) {
            throw new BadParamsException();
        }
        return departService.departMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee departMinSalary(@RequestParam(value = "departmentId", required = false) int departmentId) {
        if (departmentId <= 0) {
            throw new BadParamsException();
        }
        return departService.departMinSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List< Employee>> departAllSalary() {
        return departService.departAllSalary();
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    public Map<String, Employee> departSalary(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        return departService.departSalary(departmentId);
    }

}







