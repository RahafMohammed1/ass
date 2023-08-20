package com.example.relationsindatabase.Controller;

import com.example.relationsindatabase.Model.Customer;
import com.example.relationsindatabase.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerControllerr {
    private final CustomerService customerService;

    @GetMapping("/getall")
    public ResponseEntity getAllCustomer()
    {
        return ResponseEntity.status(200).body(customerService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer)
    {
        customerService.add(customer);
        return ResponseEntity.status(200).body("customer is added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id , @Valid @RequestBody Customer customer)
    {
        customerService.update(id,customer);
        return ResponseEntity.status(200).body("customer is updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id )
    {
        customerService.delete(id);
        return ResponseEntity.status(200).body("customer is deleted");
    }



}
