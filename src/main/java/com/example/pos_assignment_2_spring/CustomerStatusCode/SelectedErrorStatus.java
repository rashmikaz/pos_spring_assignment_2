package com.example.pos_assignment_2_spring.CustomerStatusCode;

import com.example.pos_assignment_2_spring.dto.CustomerStatus;
import com.example.pos_assignment_2_spring.dto.ItemStatus;
import com.example.pos_assignment_2_spring.dto.OrderDetailsStatus;
import com.example.pos_assignment_2_spring.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedErrorStatus implements CustomerStatus, ItemStatus, OrderStatus, OrderDetailsStatus {
    private int statusCode;
    private String statusMessage;
}
