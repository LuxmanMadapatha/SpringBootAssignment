package com.example.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class LuxmansBankApplication {

  public static void main(String[] args) {
    SpringApplication.run(LuxmansBankApplication.class, args);
  }

}
