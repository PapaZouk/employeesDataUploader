package com.datauploader.datauploader.config;

import com.datauploader.datauploader.components.repository.DBEmployeeRepository;
import com.datauploader.datauploader.components.repository.IDBEmployeeRepository;
import com.datauploader.datauploader.components.repository.InMemoryEmployeeRepository;
import com.datauploader.datauploader.service.CsvParseServiceInMemory;
import com.datauploader.datauploader.service.CsvParserService;
import com.datauploader.datauploader.service.ICsvParserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfig {

    @Bean(name = "CsvParseServiceInMemory")
    @Profile("test")
    @Primary
    public ICsvParserService createParseServiceInMemory() {
        return new CsvParseServiceInMemory();
    }

    @Bean(name = "InMemoryEmployeeRepository")
    @Profile("test")
    @Primary
    public IDBEmployeeRepository createInMemoryEmployeeRepository() {
        return new InMemoryEmployeeRepository();
    }

    @Bean(name = "ICsvParserService")
    @Profile("dev")
    @Primary
    public ICsvParserService createCsvParseService() {
        return new CsvParserService();
    }

    @Bean(name = "DBEmployeeRepository")
    @Profile("dev")
    @Primary
    public DBEmployeeRepository createDBEmployeeRepository() {
        return new DBEmployeeRepository();
    }


}
