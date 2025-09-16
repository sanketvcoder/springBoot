package com.sanket.FirstJobApp.Company.controller.Impl;

import java.util.List;

import com.sanket.FirstJobApp.Company.controller.CompanyController;
import com.sanket.FirstJobApp.Company.entity.Company;
import com.sanket.FirstJobApp.Company.service.CompanyService;

public class CompanyControllerImpl implements CompanyController{

    private final CompanyService companyService;

    public CompanyControllerImpl(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }
    
}
