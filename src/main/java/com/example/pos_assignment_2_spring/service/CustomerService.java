package com.example.pos_assignment_2_spring.service;

import com.example.pos_assignment_2_spring.dto.CustomerStatus;
import com.example.pos_assignment_2_spring.dto.Impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    CustomerStatus getCustomer(String userId);

    void deleteCustomer(String customerId);

    List<CustomerDTO> getAllCustomer();

    void updateCustomer(String customerId, CustomerDTO customerDTO);
}
