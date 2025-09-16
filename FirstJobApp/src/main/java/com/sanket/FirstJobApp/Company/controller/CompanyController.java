package com.sanket.FirstJobApp.Company.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sanket.FirstJobApp.Company.entity.Company;

public interface CompanyController {

    ResponseEntity<List<Company>> getAllCompanies();

    ResponseEntity<Company> UpdateCompany(Long Id, Company company);

    ResponseEntity<Company> addingCompany(Company company);

    ResponseEntity<String> deleteCompany(Long Id);

    ResponseEntity<Company> getCompanyById(Long id);
}
