package com.datauploader.datauploader.service;

import com.datauploader.datauploader.components.model.Employee;

import java.io.InputStream;
import java.util.List;

public interface ICsvParserService {
    List<Employee> parseCsvData(InputStream input);

    void saveDataToDB(List<Employee> data);

    void addEmployee(Employee employee);
}
