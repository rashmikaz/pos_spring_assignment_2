package com.example.pos_assignment_2_spring.dao;

import com.example.pos_assignment_2_spring.entity.Impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
