package com.example.relationsindatabase.Service;

import com.example.relationsindatabase.Api.ApiException;
import com.example.relationsindatabase.Model.Customer;
import com.example.relationsindatabase.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    final private CustomerRepository customerRepository;

    public List<Customer> getAll()
    {
        return customerRepository.findAll();
    }

    public void add(Customer customer)
    {
        customerRepository.save(customer);
    }

    public void update(Integer id,Customer customer)
    {
        Customer customer1=customerRepository.findCustomerById(id);
        if(customer1==null)
        {
            throw new ApiException("customer not found");
        }
        customer1.setName(customer.getName());
        customerRepository.save(customer1);
    }

    public void delete(Integer id)
    {

        Customer customer1=customerRepository.findCustomerById(id);
        if(customer1==null)
        {
            throw new ApiException("customer not found");
        }
        customerRepository.delete(customer1);
    }
}
