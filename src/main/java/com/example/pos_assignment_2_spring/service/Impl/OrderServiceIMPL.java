package com.example.pos_assignment_2_spring.service.Impl;

import com.example.pos_assignment_2_spring.dao.CustomerDao;
import com.example.pos_assignment_2_spring.dao.ItemDao;
import com.example.pos_assignment_2_spring.dao.OrderDao;
import com.example.pos_assignment_2_spring.dao.OrderDetailsDao;
import com.example.pos_assignment_2_spring.dto.Impl.OrderDTO;
import com.example.pos_assignment_2_spring.dto.Impl.OrderDetailsDTO;
import com.example.pos_assignment_2_spring.entity.Impl.ItemEntity;
import com.example.pos_assignment_2_spring.entity.Impl.OrderDetailsEntity;
import com.example.pos_assignment_2_spring.entity.Impl.OrderEntity;
import com.example.pos_assignment_2_spring.exception.DataPersistException;
import com.example.pos_assignment_2_spring.service.OrderService;
import com.example.pos_assignment_2_spring.utill.AppUtill;
import com.example.pos_assignment_2_spring.utill.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void placeOrder(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTOS) {
        try {
            orderDTO.setOrderId(AppUtill.generateOrderId());
            OrderEntity saveOrder = orderDao.save(mapping.toOrderEntity(orderDTO));
            if(saveOrder == null){
                throw new DataPersistException("Order not saved");
            }

            for(OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS){
                orderDetailsDTO.setDetailsId(AppUtill.generateOrderDetailsId());
                OrderDetailsEntity orderDetailsEntity = mapping.toOrderDetailsEntity(orderDetailsDTO);
                orderDetailsEntity.setOrder(saveOrder);
                orderDetailsDao.save(orderDetailsEntity);

                Optional<ItemEntity> item = itemDao.findById(String.valueOf(orderDetailsDTO.getItem()));

                if(item.isPresent()){
                    ItemEntity itemEntity = item.get();
                    int updateQty = itemEntity.getQtyOnHand() - orderDetailsDTO.getOrderQty();

                    if(updateQty < 0){
                        throw new DataPersistException("Insufficient stock for item :" + orderDetailsDTO.getItem());
                    }

                    itemEntity.setQtyOnHand(updateQty);
                    itemDao.save(itemEntity);
                }
            }
        }catch (Exception e){
            throw e;
        }
    }
}
