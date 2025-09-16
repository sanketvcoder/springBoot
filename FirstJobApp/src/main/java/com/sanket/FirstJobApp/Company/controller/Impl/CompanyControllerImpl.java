package com.sanket.FirstJobApp.Company.controller.Impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.FirstJobApp.Company.controller.CompanyController;
import com.sanket.FirstJobApp.Company.entity.Company;
import com.sanket.FirstJobApp.Company.service.CompanyService;

@RestController
@RequestMapping("/api/v1")
public class CompanyControllerImpl implements CompanyController {

    private final CompanyService companyService;

    public CompanyControllerImpl(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @Override
    @PutMapping("/company/{Id}")
    public ResponseEntity<Company> UpdateCompany(@PathVariable Long Id, @RequestBody Company company) {
        return new ResponseEntity<>(companyService.UpdateCompany(Id, company), HttpStatus.OK);

    }

}
