package com.sanket.FirstJobApp.Company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.FirstJobApp.Company.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
