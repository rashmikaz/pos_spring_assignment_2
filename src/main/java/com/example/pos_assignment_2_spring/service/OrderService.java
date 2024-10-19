package com.example.pos_assignment_2_spring.service;

import com.example.pos_assignment_2_spring.dto.Impl.OrderDTO;
import com.example.pos_assignment_2_spring.dto.Impl.OrderDetailsDTO;

import java.util.List;

public interface OrderService {
    void placeOrder(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTOS);
}
