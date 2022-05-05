package com.milestone.api.vendor;







import com.milestone.api.vendor.VendorBean;
import com.milestone.api.vendor.VendorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping({ "/milestone/vendor" })
public class VendorController {


    @Autowired
    com.milestone.api.vendor.VendorDAO VendorDAO;

    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllVendors" })
    public List<VendorBean> fetchAllVendors() throws SQLException {
        return (List<VendorBean>)this.VendorDAO.fetchAllVendors();
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/createVendor" })
    public List<VendorBean> createVendor(@RequestBody final VendorBean VendorBean) throws SQLException {
        return (List<VendorBean>)this.VendorDAO.createVendor(VendorBean);
    }
    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateVendor" })
    public List<VendorBean> updateVendor(@RequestBody final VendorBean VendorBean) throws SQLException {
        return (List<VendorBean>)this.VendorDAO.updateVendor(VendorBean);
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteVendor" })
    public List<VendorBean> deleteVendor(@RequestBody final VendorBean VendorBean) throws SQLException {
        return (List<VendorBean>)this.VendorDAO.deleteVendor(VendorBean);
    }


    @RequestMapping(method = { RequestMethod.POST }, value = { "/undoVendor" })
    public List<VendorBean> undoVendor(@RequestBody final VendorBean VendorBean) throws SQLException {
        return (List<VendorBean>)this.VendorDAO.undoVendor(VendorBean);
    }


}




