package com.example.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * app
 *
 * @author kunple
 */
@SpringBootApplication(scanBasePackages = "com.example.app1")
public class App1 {
    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }
}
