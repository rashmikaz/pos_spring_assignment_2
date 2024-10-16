package com.example.pos_assignment_2_spring.controller;

import com.example.pos_assignment_2_spring.CustomerStatusCode.SelectedErrorStatus;
import com.example.pos_assignment_2_spring.dto.CustomerStatus;
import com.example.pos_assignment_2_spring.dto.Impl.CustomerDTO;
import com.example.pos_assignment_2_spring.dto.Impl.ItemDTO;
import com.example.pos_assignment_2_spring.dto.ItemStatus;
import com.example.pos_assignment_2_spring.exception.CustomerNotFoundException;
import com.example.pos_assignment_2_spring.exception.DataPersistException;
import com.example.pos_assignment_2_spring.service.ItemService;
import com.example.pos_assignment_2_spring.utill.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        @PutMapping(value = "/{itemId}")
        public ResponseEntity<Void>updateItem(@PathVariable ("itemId") String itemId,
                                              @RequestBody ItemDTO itemDTO) {

            try {
                if (!RegexProcess.itemCodeMatcher(itemId) || itemDTO == null) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
                itemService.updateItem(itemId, itemDTO);
                logger.info("Item Updated!!");
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataPersistException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Item Not Updated!!", e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }

         @DeleteMapping(value = "/{itemId}")
         public ResponseEntity<Void> deleteItem(@PathVariable("itemId") String itemId){
             try {
                 if(!RegexProcess.itemCodeMatcher(itemId)){
                     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                 }
                 itemService.deleteItem(itemId);
                 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             } catch (CustomerNotFoundException e) {
                 e.printStackTrace();
                 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             } catch (Exception e) {
                 e.printStackTrace();
                 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
             }
         }


         @GetMapping(value = "/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE)
         public ItemStatus getSelectedItem(@PathVariable("itemId")String itemId){

             if(!RegexProcess.customerIdMatcher(itemId)){
                 logger.error("Returning Http 400 Bad Request");
                 return new SelectedErrorStatus(1,"Item ID is not valid");
             }
             return itemService.getItem(itemId);


         }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItem(){

        return itemService.getAllItem();
    }



}


