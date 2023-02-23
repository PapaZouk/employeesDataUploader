package com.datauploader.datauploader.service;

import com.datauploader.datauploader.components.model.Employee;
import com.datauploader.datauploader.components.repository.IDBEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvParseServiceInMemory implements ICsvParserService{

    @Autowired
    IDBEmployeeRepository employeeRepository;

    @Override
    public List<Employee> parseCsvData(InputStream input) {
        List<Employee> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] field = line.split(",");
                Employee employee = new Employee(field[0], field[1], field[2], field[3], field[4]);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while parsing input");
        }
        return data;
    }

    @Override
    public void saveDataToDB(List<Employee> data) {
        for (Employee employee : data) {
            employeeRepository.addEmployee(employee);
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }
}
