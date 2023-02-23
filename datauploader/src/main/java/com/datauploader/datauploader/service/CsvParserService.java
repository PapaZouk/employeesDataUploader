package com.datauploader.datauploader.service;

import com.datauploader.datauploader.components.model.Employee;
import com.datauploader.datauploader.components.repository.DBEmployeeRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvParserService implements ICsvParserService {

    @Autowired
    DBEmployeeRepository dbEmployeeRepository;

    public static List<Employee> parseCsvFile(MultipartFile file) throws IOException {
        Reader reader = new InputStreamReader(file.getInputStream());
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<Employee> employees = new ArrayList<>();
        for (CSVRecord record : csvParser) {

            String name = record.get("name");
            String surname = record.get("surname");
            String email = record.get("email");
            String gender = record.get("gender");
            String department = record.get("department");

            Employee employee = new Employee(name, surname, email, gender, department);

            employees.add(employee);
        }
        return employees;
    }

    @Override
    public List<Employee> parseCsvData(InputStream input) {
        List<Employee> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] field = line.split(",");
                Employee employee = new Employee(field[0], field[1], field[2], field[3], field[4]);
                data.add(employee);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while parsing input");
        }
        return data;
    }

    @Override
    public void saveDataToDB(List<Employee> data) {
        for (Employee employee : data) {
            dbEmployeeRepository.addEmployee(employee);
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        dbEmployeeRepository.addEmployee(employee);
    }
}
