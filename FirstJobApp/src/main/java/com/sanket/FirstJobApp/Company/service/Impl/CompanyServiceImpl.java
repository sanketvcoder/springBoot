package com.sanket.FirstJobApp.Company.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanket.FirstJobApp.Company.entity.Company;
import com.sanket.FirstJobApp.Company.repository.CompanyRepository;
import com.sanket.FirstJobApp.Company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company UpdateCompany(Long Id, Company company) {
        Company existingCompany = companyRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + Id));

        existingCompany.setName(company.getName());
        existingCompany.setDescription(company.getDescription());

        return companyRepository.save(existingCompany);
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public String deleteCompany(Long Id) {
        companyRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + Id));
        companyRepository.deleteById(Id);
        return "Company deleted with id: " + Id;
    }

}
