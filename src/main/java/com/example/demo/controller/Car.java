package com.example.demo.controller;

import org.springframework.stereotype.Component;

@Component
public class Car {
    public Car() {
        this.id = 10;
    }
    public int id;

    public void drive() {
        System.out.print("dive car");
    }
}
