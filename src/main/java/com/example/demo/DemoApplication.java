package com.example.demo;

import com.example.demo.controller.Car;
import com.example.demo.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // SpringApplication.run(DemoApplication.class, args);
        SpringApplication application = new SpringApplication(DemoApplication.class);
        ConfigurableApplicationContext context = application.run(args);
        Car car = context.getBean(Car.class);
        System.out.println(car.id);
    }

}
