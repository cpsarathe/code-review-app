package com.code.review.app.service;

import com.code.review.app.dto.common.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void register(CustomerDTO customerDTO);
    void update(CustomerDTO customerDTO);
    void delete(Long customerId);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomer(Long customerId);
}
