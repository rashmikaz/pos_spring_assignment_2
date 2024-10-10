package com.example.pos_assignment_2_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class HealthCheckController {

    public String healthTest(){

        return "note controller is working";
    }
}
