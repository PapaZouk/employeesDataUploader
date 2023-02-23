package com.datauploader.datauploader.components.repository;

import com.datauploader.datauploader.components.model.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DBEmployeeRepository implements IDBEmployeeRepository {

    @Autowired
    EntityManager manager;

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        manager.persist(employee);
    }

    @Override
    @Transactional
    public void removeEmployee(Employee employee) {
        manager.remove(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return manager.createQuery("from Employee", Employee.class).getResultList();
    }
}
