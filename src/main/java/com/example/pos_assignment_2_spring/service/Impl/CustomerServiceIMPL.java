package com.example.pos_assignment_2_spring.service.Impl;

import com.example.pos_assignment_2_spring.CustomerStatusCode.SelectedErrorStatus;
import com.example.pos_assignment_2_spring.dao.CustomerDao;
import com.example.pos_assignment_2_spring.dto.CustomerStatus;
import com.example.pos_assignment_2_spring.dto.Impl.CustomerDTO;
import com.example.pos_assignment_2_spring.entity.Impl.CustomerEntity;
import com.example.pos_assignment_2_spring.exception.CustomerNotFoundException;
import com.example.pos_assignment_2_spring.exception.DataPersistException;
import com.example.pos_assignment_2_spring.service.CustomerService;
import com.example.pos_assignment_2_spring.utill.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private Mapping mapping;
    @Autowired
    private CustomerDao customerDao;

    @Override
    public void saveCustomer(CustomerDTO customerDTO){
//        customerDTO.setCustomerId(AppUtill.generateCustomerId());
        CustomerEntity saveCustomer = customerDao.save(mapping.toCustomerEntity(customerDTO));
        if(saveCustomer == null){
            throw new DataPersistException("Customer not saved");
        }

    }

    @Override
    public CustomerStatus getCustomer(String customerId) {
        if(customerDao.existsById(customerId)){
            CustomerEntity selectedCustomer = customerDao.getReferenceById(customerId);
            return (CustomerStatus) mapping.toCustomerDto(selectedCustomer);//have some error
        }else {
            return new SelectedErrorStatus(2, "customer with id " + customerId + " not found");
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> existedUser = customerDao.findById(customerId);
        if(!existedUser.isPresent()){
            throw new CustomerNotFoundException("customer with id " + customerId + " not found");
        }else {
            customerDao.deleteById(customerId);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerEntity> allUsers = customerDao.findAll();
        return mapping.asCustomerDTOList(allUsers);
    }
}
