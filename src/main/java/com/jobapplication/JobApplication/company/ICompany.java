package com.jobapplication.JobApplication.company;

import java.util.List;

public interface ICompany {
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    void createCompany(Company company);



}
