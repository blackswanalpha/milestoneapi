package com.milestone.api.type;




import java.sql.SQLException;
import java.util.List;

import com.milestone.api.type.TypeBean;
import com.milestone.api.type.TypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping({ "/milestone/type" })
public class TypeController {

    @Autowired
    TypeDAO userDAO;

    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllTypes" })
    public List<TypeBean> fetchAllUsers() throws SQLException {
        return (List<TypeBean>)this.userDAO.fetchAllUsers();
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/createType" })
    public List<TypeBean> createUser(@RequestBody final TypeBean userBean) throws SQLException {
        return (List<TypeBean>)this.userDAO.createUser(userBean);
    }
    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateType" })
    public List<TypeBean> updateGroup(@RequestBody final TypeBean groupBean) throws SQLException {
        return (List<TypeBean>)this.userDAO.updateGroup(groupBean);
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteType" })
    public List<TypeBean> deleteGroup(@RequestBody final TypeBean groupBean) throws SQLException {
        return (List<TypeBean>)this.userDAO.deleteGroup(groupBean);
    }

}