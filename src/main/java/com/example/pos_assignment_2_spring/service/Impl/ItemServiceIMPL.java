package com.example.pos_assignment_2_spring.service.Impl;

import com.example.pos_assignment_2_spring.dao.ItemDao;
import com.example.pos_assignment_2_spring.dto.Impl.ItemDTO;
import com.example.pos_assignment_2_spring.entity.Impl.ItemEntity;
import com.example.pos_assignment_2_spring.exception.DataPersistException;
import com.example.pos_assignment_2_spring.exception.ItemNotFoundException;
import com.example.pos_assignment_2_spring.service.ItemService;
import com.example.pos_assignment_2_spring.utill.AppUtill;
import com.example.pos_assignment_2_spring.utill.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    @Override
    public void updateItem(String itemId, ItemDTO itemDTO){
        Optional<ItemEntity> tmpItem = itemDao.findById(itemId);
        if(!tmpItem.isPresent()){
            throw new ItemNotFoundException("Item ID With" + itemId + "Not Found");
        }else {
            tmpItem.get().setItemName(itemDTO.getItemName());
            tmpItem.get().setQtyOnHand(itemDTO.getQtyOnHand());
            tmpItem.get().setUnitPrice(itemDTO.getUnitPrice());
        }

    }
}
