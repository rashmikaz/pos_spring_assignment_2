package com.example.pos_assignment_2_spring.dto.Impl;

import com.example.pos_assignment_2_spring.dto.OrderRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequestDTO implements OrderRequestStatus {
    private OrderDTO order;
    private List<OrderDetailsDTO> orderDetails;
}
