package com.example.pos_assignment_2_spring.dto.Impl;


import com.example.pos_assignment_2_spring.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerTel;
}
