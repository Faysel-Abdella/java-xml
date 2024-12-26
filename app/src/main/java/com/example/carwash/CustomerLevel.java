package com.example.carwash;

public class CustomerLevel {
    String description;
    String level;
    double generalPrice;
    int imageId;

    public CustomerLevel(String description, String level, double generalPrice, int imageId) {
        this.description = description;
        this.level = level;
        this.generalPrice = generalPrice;
        this.imageId = imageId;
    }
}
