package com.inforesources.studentservice.controller;

import com.inforesources.studentservice.dto.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping(path="hello")
    public GenericResponse sayHello(@RequestParam String name) {
        return new GenericResponse("hello world" + name);
    }
}
