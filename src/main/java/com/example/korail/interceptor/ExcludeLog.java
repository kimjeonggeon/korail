package com.example.korail.interceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ExcludeLog {

        public static void main(String[] args) {
            SpringApplication.run(ExcludeLog.class, args);
        }

}
