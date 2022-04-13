package com.aforo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
public class AppTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppTransactionApplication.class, args);
    }

}
