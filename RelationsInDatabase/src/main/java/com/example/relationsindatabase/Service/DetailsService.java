package com.example.relationsindatabase.Service;

import com.example.relationsindatabase.DTO.CustomrDTO;
import com.example.relationsindatabase.Model.Customer;
import com.example.relationsindatabase.Model.Details;
import com.example.relationsindatabase.Repository.CustomerRepository;
import com.example.relationsindatabase.Repository.DetailsRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailsService {
private final CustomerRepository customerRepository;
private final DetailsRepository detailsRepository;


public List<Details> getall()
{
   return detailsRepository.findAll() ;
}
public void add(CustomrDTO customrDTO)
    {
        Customer customer=customerRepository.findCustomerById(customrDTO.getCustomer_Id());

        Details details=new Details(null,customrDTO.getGender(),customrDTO.getAge(),customrDTO.getEmail(),customer);
        detailsRepository.save(details);

    }

    public void update( Integer id,CustomrDTO customrDTO)
    {

        Details details=detailsRepository.findDetailsById(id);
        details.setAge(customrDTO.getAge());
        details.setGender(customrDTO.getGender());
        details.setEmail(customrDTO.getEmail());
        detailsRepository.save(details);

    }

    public void delete( Integer id) {
        Details details = detailsRepository.findDetailsById(id);
        Customer customer=customerRepository.findCustomerById(details.getCustomer().getId());
        customer.setDetails(null);
        customerRepository.save(customer);
        detailsRepository.delete(details);
    }




}
