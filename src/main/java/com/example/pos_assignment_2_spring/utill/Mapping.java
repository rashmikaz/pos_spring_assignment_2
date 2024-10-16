package com.example.pos_assignment_2_spring.utill;

import com.example.pos_assignment_2_spring.dao.ItemDao;
import com.example.pos_assignment_2_spring.dto.Impl.CustomerDTO;
import com.example.pos_assignment_2_spring.dto.Impl.ItemDTO;
import com.example.pos_assignment_2_spring.dto.Impl.OrderDTO;
import com.example.pos_assignment_2_spring.dto.Impl.OrderDetailsDTO;
import com.example.pos_assignment_2_spring.entity.Impl.CustomerEntity;
import com.example.pos_assignment_2_spring.entity.Impl.ItemEntity;
import com.example.pos_assignment_2_spring.entity.Impl.OrderDetailsEntity;
import com.example.pos_assignment_2_spring.entity.Impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemDao itemDao;

    //For Customer Mapping
    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO,CustomerEntity.class);
    }

    public CustomerDTO toCustomerDto(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity,CustomerDTO.class);
    }

    public List<CustomerDTO> asCustomerDTOList(List<CustomerEntity> customerEntityList){
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    //For Item Mapping
    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

    public ItemDTO toItemDto(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    public List<ItemDTO> asItemDTOList(List<ItemEntity> itemEntityList){
        return modelMapper.map(itemEntityList, new TypeToken<List<ItemDTO>>() {}.getType());
    }

    //For order
    public OrderEntity toOrderEntity(OrderDTO orderDTO){
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    //For Order Details
    public OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDTO orderDetailsDTO){
        return modelMapper.map(orderDetailsDTO,OrderDetailsEntity.class);
    }

    public List<OrderDetailsDTO> asOrderDetailsDTOList(List<OrderDetailsEntity> orderDetailsEntities){
        return modelMapper.map(orderDetailsEntities,new TypeToken<List<OrderDetailsDTO>>() {}.getType());
    }

}
