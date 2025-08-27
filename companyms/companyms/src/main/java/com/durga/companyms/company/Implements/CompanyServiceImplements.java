package com.durga.companyms.company.Implements;

import com.durga.companyms.company.Company;
import com.durga.companyms.company.CompanyRepository;
import com.durga.companyms.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplements implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImplements(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    @Override
    public Boolean deleteById(Long companyId) {
        try{
            companyRepository.deleteById(companyId);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean updateCompany(Long companyId, Company updateCompany) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setCompany_description(updateCompany.getCompany_description());
            company.setCompany_name(updateCompany.getCompany_name());
            company.setCompany_location(updateCompany.getCompany_location());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }
}
