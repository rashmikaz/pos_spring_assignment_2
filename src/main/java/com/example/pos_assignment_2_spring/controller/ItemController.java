package com.example.pos_assignment_2_spring.controller;

import com.example.pos_assignment_2_spring.dto.Impl.ItemDTO;
import com.example.pos_assignment_2_spring.exception.DataPersistException;
import com.example.pos_assignment_2_spring.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/V1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveItem(@RequestBody ItemDTO itemDTO) {
        try {
            itemService.saveItem(itemDTO);
            logger.info("Item Saved!!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Item Not Saved!!", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }



}


