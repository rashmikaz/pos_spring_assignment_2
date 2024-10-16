package com.example.pos_assignment_2_spring.utill;

import java.util.UUID;

public class AppUtill {

    public static String generateCustomerId(){
        return "CUS-" + UUID.randomUUID();
    }

    public static String generateItemId(){
        return "ITEM-" + UUID.randomUUID();
    }

    public static String generateOrderId(){
        return "ORDER-" + UUID.randomUUID();
    }
    public static String generateOrderDetailsId(){
        return "DETAILS-" + UUID.randomUUID();
    }

}
