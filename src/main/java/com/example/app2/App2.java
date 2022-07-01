package com.example.app2;

import com.alipay.sofa.runtime.SofaRuntimeProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * app
 *
 * @author kunple
 */
@SpringBootApplication(scanBasePackages = "com.example.app2")
public class App2 {
    public static void main(String[] args) {
//        SofaRuntimeProperties.setDisableJvmFirst(Thread.currentThread().getContextClassLoader(), true);
        SpringApplication.run(App2.class, args);
    }
}
