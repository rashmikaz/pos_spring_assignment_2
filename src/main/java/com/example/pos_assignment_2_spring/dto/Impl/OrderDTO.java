package com.example.pos_assignment_2_spring.dto.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private String orderId;
    private String customerId;
    private LocalDate orderDate;
//    private List<OrderDetailsDTO> orderDetails;
}
