package com.durga.firstjobapp.company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company findById(Long companyId);
    Boolean deleteById(Long companyId);
    Boolean updateCompany(Long companyId,Company company);
    void createCompany(Company company);
}
