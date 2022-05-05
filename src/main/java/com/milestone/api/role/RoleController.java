package com.milestone.api.role;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping({ "/milestone/role" })
public class RoleController {

    @Autowired
    RoleDAO userDAO;

    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllRoles" })
    public List<RoleBean> fetchAllUsers() throws SQLException {
        return (List<RoleBean>)this.userDAO.fetchAllUsers();
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/createRole" })
    public List<RoleBean> createUser(@RequestBody final RoleBean userBean) throws SQLException {
        return (List<RoleBean>)this.userDAO.createUser(userBean);
    }
    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateRole" })
    public List<RoleBean> updateGroup(@RequestBody final RoleBean groupBean) throws SQLException {
        return (List<RoleBean>)this.userDAO.updateGroup(groupBean);
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteRole" })
    public List<RoleBean> deleteGroup(@RequestBody final RoleBean groupBean) throws SQLException {
        return (List<RoleBean>)this.userDAO.deleteGroup(groupBean);
    }

}



