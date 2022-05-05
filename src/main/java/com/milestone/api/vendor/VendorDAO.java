package com.milestone.api.vendor;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.milestone.api.vendor.VendorBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class VendorDAO {
    PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
    public VendorDAO() {
        super();
        this.cst = null;
        this.conn = null;
    }

    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "vendor_id";
        final String table_name = "vendor";
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




    public List<VendorBean> fetchAllVendors() throws SQLException {
        final String selectSQL = "SELECT vendor_id,vendor_name,vendor_img,vendor_desc, vendor_type_id,vendor_location, vendor_cost,vendor_company_id	 FROM vendor,company  where not vendor_status_id = 2 and  vendor_company_id =company_id  ";
        final List<VendorBean>vendorList = new ArrayList<VendorBean>();
        try {
            this.conn = this.dataSource.getConnection();
            this.cst = this.conn.prepareStatement(selectSQL);
            final ResultSet rs = this.cst.executeQuery();
            while (rs.next()) {
                final VendorBean vendor = new VendorBean();
                vendor.setVendorId(rs.getInt("vendor_id"));

                vendor.setVendorName(rs.getString("vendor_name"));
                vendor.setVendorImg(rs.getString("vendor_img"));
                vendor.setVendorDesc(rs.getString("vendor_desc"));
                vendor.setVendorTypeId(rs.getInt("vendor_type_id"));
                //  vendor.setVendorContact(rs.getInt("vendor_contact"));
                vendor.setVendorCost(rs.getFloat("vendor_cost"));
                vendor.setVendorCompanyId(rs.getInt("vendor_company_id"));


                vendorList.add(vendor);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return vendorList;
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return vendorList;
    }
    public List<VendorBean> createVendor(final VendorBean vendorBean) throws SQLException {
        final String selectSQL = "INSERT INTO vendor(vendor_id,vendor_name,vendor_img,vendor_type_id,vendor_desc, vendor_cost,vendor_company_id,vendor_status_id) values(" + this.getNextPrimaryKey() + ", '" + vendorBean.getVendorName() +  "', '"+vendorBean.getVendorImg()+ "', " + vendorBean.getVendorTypeId()  +  ", '" + vendorBean.getVendorDesc() +  "', " + vendorBean.getVendorCost() +  ", " + vendorBean.getVendorCompanyId() +  ",1);";
        List<VendorBean>vendorList = new ArrayList<VendorBean>();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<VendorBean>)this.fetchAllVendors();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        vendorList = (List<VendorBean>)this.fetchAllVendors();
        return vendorList;
    }

    public List<VendorBean> updateVendor(final VendorBean vendorBean) throws SQLException {
        final String sql = "update vendor set vendor_name='" + vendorBean.getVendorName() +"', vendor_company_id=" +vendorBean.getVendorCompanyId()+",vendor_cost="+vendorBean.getVendorCost() +",vendor_type_id="+vendorBean.getVendorTypeId() +",vendor_desc='"+vendorBean.getVendorDesc() +"',vendor_img='"+vendorBean.getVendorImg()+ "' where vendor_id=" +vendorBean.getVendorId();
        System.out.println(sql);
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<VendorBean>)this.fetchAllVendors();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<VendorBean>)this.fetchAllVendors();
    }

    public List<VendorBean> deleteVendor(final VendorBean vendorBean) throws SQLException {
        final String sql = "update vendor set vendor_status_id = 2  WHERE vendor_id=" +vendorBean.getVendorId();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<VendorBean>)this.fetchAllVendors();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<VendorBean>)this.fetchAllVendors();
    }

    public List<VendorBean> undoVendor(VendorBean vendorBean) throws SQLException {
        final String sql = "update vendor set vendor_status_id = 1  WHERE vendor_id=" + vendorBean.getVendorId();

        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<VendorBean>)this.fetchAllVendors();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<VendorBean>)this.fetchAllVendors();
    }

}




