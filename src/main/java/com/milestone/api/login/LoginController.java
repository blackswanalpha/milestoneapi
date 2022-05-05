package com.milestone.api.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping({ "/milestone/login" })
public class LoginController {
	
	 @Autowired
	    LoginDAO loginDAO;
	    
	    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllLogins" })
	    public List<LoginBean> fetchAllLogins() throws SQLException {
	        return (List<LoginBean>)this.loginDAO.fetchAllLogins();
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/createLogin" })
	    public List<LoginBean> createLogin(@Valid @RequestBody final LoginBean loginBean) throws SQLException {
	        return (List<LoginBean>)this.loginDAO.createLogin(loginBean);
	    }
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateLogin" })
	    public List<LoginBean> updateLogin(@RequestBody final LoginBean loginBean) throws SQLException {
	        return (List<LoginBean>)this.loginDAO.updateLogin(loginBean);
	    }
	    
	    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteLogin" })
	    public List<LoginBean> deleteLogin(@Valid @RequestBody final LoginBean loginBean) throws SQLException {
	        return (List<LoginBean>)this.loginDAO.deleteLogin(loginBean);
	    }

	@RequestMapping(method = { RequestMethod.GET }, value = { "/findByName" })
	public LoginBean findByName(@RequestParam String loginName) throws SQLException {
		return this.loginDAO.findByName(loginName);
	}
	    

}
