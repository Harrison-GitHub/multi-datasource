package com.harrison.mutidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MutiDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MutiDatasourceApplication.class, args);
    }

}
