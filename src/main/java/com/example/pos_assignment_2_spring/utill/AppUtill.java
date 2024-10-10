package com.example.pos_assignment_2_spring.utill;

import java.util.UUID;

public class AppUtill {

    public static String generateCustomerId(){
        return "CUS-" + UUID.randomUUID();
    }
}
