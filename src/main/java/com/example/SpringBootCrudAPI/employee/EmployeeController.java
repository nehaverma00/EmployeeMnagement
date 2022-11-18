package com.example.SpringBootCrudAPI.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> get(){
        return employeeService.get();
    }
    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }
    @GetMapping("/employee/{id}")
    public Employee get(@PathVariable int id){
        Employee employeeObj= employeeService.get(id);
        if(employeeObj==null){
            throw new RuntimeException("Employee with id"+id+"is not found");
        }
        return employeeObj;
    }
    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "Employee has been deleted:"+id;
    }
    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employeeObj){
        employeeService.save(employeeObj);
        return employeeObj;
    }
}
