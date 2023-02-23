package com.datauploader.datauploader.controllers;

import com.datauploader.datauploader.components.model.Employee;
import com.datauploader.datauploader.components.repository.IDBEmployeeRepository;
import com.datauploader.datauploader.service.ICsvParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class FileUploadController {

    @Autowired
    private IDBEmployeeRepository idbEmployeeRepository;

    @Autowired
    private ICsvParserService service;

    @PostMapping("/upload-csv")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            List<Employee> data = service.parseCsvData(file.getInputStream());
            for (Employee employee : data) {
                idbEmployeeRepository.addEmployee(employee);
            }
            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return idbEmployeeRepository.getAllEmployees();
    }
}

