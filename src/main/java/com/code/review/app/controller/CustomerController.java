package com.code.review.app.controller;

import com.code.review.app.dto.common.CustomerDTO;
import com.code.review.app.service.CustomerService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
@CommonsLog
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/register" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.register(customerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/viewall" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        return new ResponseEntity(customerDTOList,HttpStatus.OK);
    }

    @GetMapping(value = "/search" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CustomerDTO> getAllCustomersByEmail(@RequestParam(name = "email") String email) {
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        List<CustomerDTO> resultCustomers = new ArrayList<>();
        for(CustomerDTO customerDTO : customerDTOList) {
            if(customerDTO.getEmail().equals(email)) {
                resultCustomers.add(customerDTO);
            }
        }
        return new ResponseEntity(resultCustomers,HttpStatus.OK);
    }

}
