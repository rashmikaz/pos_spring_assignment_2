package com.example.pos_assignment_2_spring.controller;

import com.example.pos_assignment_2_spring.dto.Impl.OrderRequestDTO;
import com.example.pos_assignment_2_spring.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO){
//        try {
//            orderService.placeOrder(orderRequestDTO.getOrder(),orderRequestDTO.getOrderDetails());
//            logger.info("Order successfully placed");
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }catch (DataPersistException e){
//            logger.warn("Returning 400 Bad Request",e.getMessage());
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }catch (Exception e){
//            logger.error("Save order unsuccessful",e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }

    }
}
