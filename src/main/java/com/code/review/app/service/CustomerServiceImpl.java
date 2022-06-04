package com.code.review.app.service;

import com.code.review.app.domain.Customer;
import com.code.review.app.dto.common.CustomerDTO;
import com.code.review.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void register(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setEmail(customerDTO.getEmail());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        customer.setPassword(customerDTO.getPassword());

        this.sendEmail(customerDTO);
        this.sendSMS(customerDTO);

        customerRepository.save(customer);
    }

    @Override
    public void update(CustomerDTO customerDTO) {

    }

    @Override
    public void delete(Long customerId) {

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for(Customer customer : customers) {
            CustomerDTO  customerDTO = new CustomerDTO();
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setFirstName(customer.getFirstName());
            customerDTO.setLastName(customer.getLastName());
            customerDTO.setMobileNumber(customer.getMobileNumber());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO getCustomer(Long customerId) {
        return null;
    }

    private void sendEmail(CustomerDTO customerDTO) {
        //Assume all preparation is done to send email
    }

    private void sendSMS(CustomerDTO customerDTO) {
        //Assume all preparation is done to send sms
    }
}
