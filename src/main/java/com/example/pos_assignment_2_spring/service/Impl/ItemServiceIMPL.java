package com.example.pos_assignment_2_spring.service.Impl;

import com.example.pos_assignment_2_spring.dao.ItemDao;
import com.example.pos_assignment_2_spring.dto.Impl.ItemDTO;
import com.example.pos_assignment_2_spring.entity.Impl.ItemEntity;
import com.example.pos_assignment_2_spring.exception.DataPersistException;
import com.example.pos_assignment_2_spring.service.ItemService;
import com.example.pos_assignment_2_spring.utill.AppUtill;
import com.example.pos_assignment_2_spring.utill.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private Mapping mapping;

    @Autowired
    private ItemDao itemDao;

    @Override
    public void saveItem(ItemDTO itemDTO){
        itemDTO.setItemCode(AppUtill.generateItemId());
        ItemEntity saveItem = itemDao.save(mapping.toItemEntity(itemDTO));
        if(saveItem == null){
            throw new DataPersistException("Item Not Saved");
        }

    }
}
