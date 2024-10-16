package com.example.pos_assignment_2_spring.dto.Impl;

import com.example.pos_assignment_2_spring.dto.OrderDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO implements OrderDetailsStatus {
    private String detailsId;
    private OrderDTO order;
    private ItemDTO item;
    private int orderQty;
    private double unitPrice;
}
