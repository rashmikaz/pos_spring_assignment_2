package com.example.pos_assignment_2_spring.dao;

import com.example.pos_assignment_2_spring.entity.Impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<ItemEntity,String> {
}
