package com.milestone.api.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping({ "/milestone/company" })
public class CompanyController {


    @Autowired
    CompanyDAO CompanyDAO;

    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllCompanys" })
    public List<CompanyBean> fetchAllCompanys() throws SQLException {
        return (List<CompanyBean>)this.CompanyDAO.fetchAllCompanys();
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/createCompany" })
    public List<CompanyBean> createCompany(@RequestBody final CompanyBean CompanyBean) throws SQLException {
        return (List<CompanyBean>)this.CompanyDAO.createCompany(CompanyBean);
    }
    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateCompany" })
    public List<CompanyBean> updateCompany(@RequestBody final CompanyBean CompanyBean) throws SQLException {
        return (List<CompanyBean>)this.CompanyDAO.updateCompany(CompanyBean);
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteCompany" })
    public List<CompanyBean> deleteCompany(@RequestBody final CompanyBean CompanyBean) throws SQLException {
        return (List<CompanyBean>)this.CompanyDAO.deleteCompany(CompanyBean);
    }


    @RequestMapping(method = { RequestMethod.POST }, value = { "/undoCompany" })
    public List<CompanyBean> undoCompany(@RequestBody final CompanyBean CompanyBean) throws SQLException {
        return (List<CompanyBean>)this.CompanyDAO.undoCompany(CompanyBean);
    }


}

