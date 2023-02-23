package com.datauploader.datauploader.components.repository;

import com.datauploader.datauploader.components.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InMemoryEmployeeRepository implements IDBEmployeeRepository{

    private Map<Integer, Employee> employeeMap = new TreeMap<>();
    @Override
    public void addEmployee(Employee employee) {
        employeeMap.put(Math.toIntExact(employee.getId()), employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        employeeMap.remove(Math.toIntExact(employee.getId()));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMap.values().stream().toList();
    }
}
