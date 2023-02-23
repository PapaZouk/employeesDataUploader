package com.datauploader.datauploader.components.repository;

import com.datauploader.datauploader.components.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDBEmployeeRepository {
    @Transactional
    void addEmployee(Employee employee);

    @Transactional
    void removeEmployee(Employee employee);

    List<Employee> getAllEmployees();
}
