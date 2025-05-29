package com.p99soft.api.controller;

import com.p99soft.api.model.Employee;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();
    private Long idCounter = 3L;

    @PostConstruct
    public void init() {
        employeeList.add(new Employee(1L, "Alice Johnson", "Project Apollo", "New York"));
        employeeList.add(new Employee(2L, "Bob Smith", "Project Gemini", "San Francisco"));
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        Optional<Employee> emp = employeeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
        return emp.orElse(null);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(idCounter++);
        employeeList.add(employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                emp.setName(updatedEmployee.getName());
                emp.setCurrentProject(updatedEmployee.getCurrentProject());
                emp.setLocation(updatedEmployee.getLocation());
                return emp;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeList.removeIf(emp -> emp.getId().equals(id));
        return "Deleted employee with id " + id;
    }
}
