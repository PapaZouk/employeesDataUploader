package com.datauploader.datauploader;

import com.datauploader.datauploader.components.model.Employee;
import com.datauploader.datauploader.components.repository.IDBEmployeeRepository;
import com.datauploader.datauploader.service.ICsvParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    ICsvParserService service;

    @Autowired
    IDBEmployeeRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        Path source = Paths.get("src/main/resources/MOCK_DATA.csv");
//        List<Employee> employees = service.parseCsvData(new FileInputStream(source.toFile()));
//
//        service.saveDataToDB(employees);
//
//        System.out.println(repository.getAllEmployees());



    }
}
