package com.example.relationsindatabase.DTO;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomrDTO {

    private Integer customer_Id;
    private String gender;
    private Integer age;
    private String email;
}
