package com.academia;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static javafx.application.Application.launch;

@SpringBootApplication
public class SpringBootMain {
    public static void main(String[] args) {
        launch(JavaFxApplication.class, args);
    }
}