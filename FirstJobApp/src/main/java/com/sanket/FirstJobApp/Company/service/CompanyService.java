package com.sanket.FirstJobApp.Company.service;

import java.util.List;

import com.sanket.FirstJobApp.Company.entity.Company;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company UpdateCompany(Long Id, Company company);

    Company addCompany(Company company);

    String deleteCompany(Long Id);
}
