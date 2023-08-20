package com.example.relationsindatabase.Repository;

import com.example.relationsindatabase.Model.Customer;
import com.example.relationsindatabase.Model.Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<Details,Integer> {
    Details findDetailsById(Integer id);
}
