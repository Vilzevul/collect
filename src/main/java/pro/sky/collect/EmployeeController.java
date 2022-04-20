package pro.sky.collect;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collect.Exception.BadParamsException;

import java.util.HashMap;

@RequestMapping(path = "/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeServise) {
        this.employeeService = employeeServise;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        employeeService.initMap();
    }

    @GetMapping(path = "/find")
    Employee find(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "lastname", required = false) String lastName) {
        if ((name == null) || (lastName == null)) {
            throw new BadParamsException();
        }
        return employeeService.find(name, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "lastname", required = false) String lastName) {
        if ((name == null) || (lastName == null)) {
            throw new BadParamsException();
        }
        return employeeService.remove(name, lastName);
    }
    @GetMapping (path = "/add")
    public Employee add(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "lastname", required = false) String lastName) {
        if ((name == null) || (lastName == null)) {
            throw new BadParamsException();
        }
        return employeeService.add(name, lastName);
    }
    @GetMapping(path = "/list")
    public HashMap<String,Employee> mapListEmployee() {
        return employeeService.mapListEmployee();
    }
}
