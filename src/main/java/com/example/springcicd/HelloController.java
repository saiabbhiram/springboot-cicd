package com.example.springcicd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is UP!";
    }

    @GetMapping("/api/greet")
    public String greet(@RequestParam(name = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
}
