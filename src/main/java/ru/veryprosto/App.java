package ru.veryprosto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.veryprosto.service.Init;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        Init.init();
        SpringApplication.run(App.class);

    }
}
