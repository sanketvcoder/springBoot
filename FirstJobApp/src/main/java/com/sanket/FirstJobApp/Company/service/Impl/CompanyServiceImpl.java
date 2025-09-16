package com.sanket.FirstJobApp.Company.service.Impl;

import java.util.List;

import com.sanket.FirstJobApp.Company.entity.Company;
import com.sanket.FirstJobApp.Company.repository.CompanyRepository;
import com.sanket.FirstJobApp.Company.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

}
