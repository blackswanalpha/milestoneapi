package com.milestone.api.company;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.milestone.api.company.CompanyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CompanyDAO {
    PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
    public CompanyDAO() {
        super();
        this.cst = null;
        this.conn = null;
    }

    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "company_id";
        final String table_name = "company";
        final String sql = "SELECT MAX(" + column_name + ") FROM " + table_name;
        int primary = 0;
        try {
            this.conn = this.dataSource.getConnection();
            this.cst = this.conn.prepareStatement(sql);
            final ResultSet rs = this.cst.executeQuery();
            while (rs.next()) {
                primary = rs.getInt(1);
                ++primary;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return primary;
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return primary;
    }




    public List<CompanyBean> fetchAllCompanys() throws SQLException {
        final String selectSQL = "SELECT company_id,company_name,company_desc,company_email, company_contact,company_location, company_address,company_user_id	 FROM company,user  where not company_status_id = 2 and  company_user_id =user_id  ";
        final List<CompanyBean>companyList = new ArrayList<CompanyBean>();
        try {
            this.conn = this.dataSource.getConnection();
            this.cst = this.conn.prepareStatement(selectSQL);
            final ResultSet rs = this.cst.executeQuery();
            while (rs.next()) {
                final CompanyBean company = new CompanyBean();
                company.setCompanyId(rs.getInt("company_id"));

                company.setCompanyName(rs.getString("company_name"));
                company.setCompanyEmail(rs.getString("company_email"));
                company.setCompanyLocation(rs.getString("company_location"));
                company.setCompanyAddress(rs.getString("company_address"));
                company.setCompanyContact(rs.getInt("company_contact"));
                company.setCompanyDesc(rs.getString("company_desc"));



                companyList.add(company);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return companyList;
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return companyList;
    }
    public List<CompanyBean> createCompany(final CompanyBean companyBean) throws SQLException {
        final String selectSQL = "INSERT INTO company(company_id,company_name,company_desc,company_email, company_contact,company_location, company_address,company_user_id,company_status_id) values(" + this.getNextPrimaryKey() + ", '" + companyBean.getCompanyName() +  "', '"+companyBean.getCompanyDesc()+ "', '" + companyBean.getCompanyEmail() +   "', " + companyBean.getCompanyContact() +  ", '" + companyBean.getCompanyLocation() +  "', '" + companyBean.getCompanyAddress() +  "', " + companyBean.getCompanyUserId() +  ",1);";
        List<CompanyBean>companyList = new ArrayList<CompanyBean>();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<CompanyBean>)this.fetchAllCompanys();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        companyList = (List<CompanyBean>)this.fetchAllCompanys();
        return companyList;
    }

    public List<CompanyBean> updateCompany(final CompanyBean companyBean) throws SQLException {
        final String sql = "update company set company_name='" + companyBean.getCompanyName() +"', company_user_id=" +companyBean.getCompanyUserId()+", company_contact=" +companyBean.getCompanyContact()+",company_desc='"+companyBean.getCompanyDesc() +"',company_email='"+companyBean.getCompanyEmail() +"',company_location='"+companyBean.getCompanyLocation() +"',company_address='"+companyBean.getCompanyAddress()+ "' where company_id=" +companyBean.getCompanyId();
        System.out.println(sql);
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<CompanyBean>)this.fetchAllCompanys();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<CompanyBean>)this.fetchAllCompanys();
    }

    public List<CompanyBean> deleteCompany(final CompanyBean companyBean) throws SQLException {
        final String sql = "update company set company_status_id = 2  WHERE company_id=" +companyBean.getCompanyId();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<CompanyBean>)this.fetchAllCompanys();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<CompanyBean>)this.fetchAllCompanys();
    }

    public List<CompanyBean> undoCompany(CompanyBean companyBean) throws SQLException {
        final String sql = "update company set company_status_id = 1  WHERE company_id=" + companyBean.getCompanyId();

        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<CompanyBean>)this.fetchAllCompanys();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<CompanyBean>)this.fetchAllCompanys();
    }

}

