package com.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class SpringBootSmartEcommerce {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootSmartEcommerce.class, args);
  }
}
