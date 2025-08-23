package com.durga.firstjobapp.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// get/companies
// get/companies/{id}
// post/companies
// put/companies/{id}
// delete/companies/{id}
@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping("")
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> findById(@PathVariable Long companyId){
        Company company = companyService.findById(companyId);
        if(company == null) return new ResponseEntity<>(company,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(company,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created successfully",HttpStatus.OK);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteById(@PathVariable Long companyId){
        Boolean deleted = companyService.deleteById(companyId);
        if(deleted) return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable Long companyId,@RequestBody Company updateCompany){
        Boolean updated = companyService.updateCompany(companyId,updateCompany);
        if(updated) return new ResponseEntity<>("Company updated successfully",HttpStatus.OK);
        return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
    }
}
