package com.example.pos_assignment_2_spring.service;

import com.example.pos_assignment_2_spring.dto.Impl.ItemDTO;
import com.example.pos_assignment_2_spring.dto.ItemStatus;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    void updateItem(String itemId, ItemDTO itemDTO);

    void deleteItem(String itemId);

    ItemStatus getItem(String itemId);
}
