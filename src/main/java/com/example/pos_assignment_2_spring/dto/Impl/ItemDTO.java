package com.example.pos_assignment_2_spring.dto.Impl;

import com.example.pos_assignment_2_spring.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements ItemStatus {
    private String itemCode;
    private String itemName;
    private int qtyOnHand;
    private double unitPrice;
}
