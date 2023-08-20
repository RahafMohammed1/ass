package com.example.relationsindatabase.Controller;

import com.example.relationsindatabase.DTO.CustomrDTO;
import com.example.relationsindatabase.Model.Customer;
import com.example.relationsindatabase.Repository.DetailsRepository;
import com.example.relationsindatabase.Service.DetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/detail")
public class DetailsController {
    private final DetailsService detailsService;
    @GetMapping("/getall")
    public ResponseEntity getAllCustomer()
    {
        return ResponseEntity.status(200).body(detailsService.getall());
    }
    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody CustomrDTO customrDTO)
    {
        detailsService.add(customrDTO);
        return ResponseEntity.status(200).body("detail is added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id , @Valid @RequestBody  CustomrDTO customrDTO)
    {
        detailsService.update(id,customrDTO);
        return ResponseEntity.status(200).body("detail is updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id )
    {
        detailsService.delete(id);
        return ResponseEntity.status(200).body("detail is deleted");
    }
}
