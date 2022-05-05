package com.milestone.api.login;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



@Repository
public class LoginDAO {

	
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;


	//	@Autowired
//	PasswordEncoder passwordEncoder;
		public LoginDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "login_id";
	        final String table_name = "login";
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
	    
	    
	    
		
		 public List<LoginBean> fetchAllLogins() throws SQLException {


		        final String selectSQL = "SELECT login_id,login_username,login_password,login_role_id ,role_name	 FROM login,role ";
		        final List<LoginBean> loginList = new ArrayList<LoginBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final LoginBean login = new LoginBean();
		                login.setLoginId(rs.getInt("login_id"));
		                
		                login.setLoginName(rs.getString("login_username"));
		                login.setLoginPassword(rs.getString("login_password"));
						login.setRoleName(rs.getString("role_name"));

						login.setLoginRoleId(rs.getInt("login_role_id"));
		                
		               
		                loginList.add(login);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return loginList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return loginList;
		    }

public Boolean checkExistByName(String name) throws SQLException {
			LoginBean sist= findByName(name);
	System.out.println("error");
	System.out.println(sist == null);
	System.out.println(sist.getLoginName());
			if (sist.getLoginName() == null){return  false;}


	return true;
}

	public LoginBean findByName(String loginName) throws SQLException {

		final String selectSQL = "SELECT login_id,login_username,login_password,login_role_id,role_name	 FROM login,role  where login_username = '" + loginName+"' and login_role_id = role_id   ";
//		final List<LoginBean> loginList = new ArrayList<LoginBean>();
		final LoginBean login = new LoginBean();
	//	if (login.getLoginName() ==null){throw  new RuntimeException("no user returned null");}
	ResultSet rs = null;
		try {
			this.conn = this.dataSource.getConnection();
			this.cst = this.conn.prepareStatement(selectSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = this.cst.executeQuery();

			rs.last();
			System.out.println("Size is " + rs.getRow());

		rs.first();

	login.setLoginId(rs.getInt("login_id"));

	login.setLoginName(rs.getString("login_username"));
	login.setLoginPassword(rs.getString("login_password"));
	login.setRoleName(rs.getString("role_name"));

	login.setLoginRoleId(rs.getInt("login_role_id"));



//				loginList.add(login);

			rs.close();


		}
		catch (Exception e) {
			e.printStackTrace();
			return login;
		}
		finally {
			rs.close();
			cst.close();
			this.conn.close();
		}
		this.conn.close();
		return login;
	}


		    public List<LoginBean> createLogin(LoginBean loginBean) throws SQLException {



					// loginBean.setLoginPassword(passwordEncoder.encode(loginBean.getLoginPassword()));
					 final String selectSQL = "INSERT INTO login(login_id,login_username,login_password,login_role_id) values(" + this.getNextPrimaryKey() + ", '" + loginBean.getLoginName() + "', '" + loginBean.getLoginPassword() + "', " + loginBean.getLoginRoleId() + ");";
					 List<LoginBean> loginList = new ArrayList<LoginBean>();
					 try {
						 this.conn = this.dataSource.getConnection();
						 (this.cst = this.conn.prepareStatement(selectSQL)).execute();
					 } catch (Exception e) {
						 e.printStackTrace();
						 return (List<LoginBean>) this.fetchAllLogins();
					 } finally {
						 this.conn.close();
					 }
					 this.conn.close();
					 loginList = (List<LoginBean>) this.fetchAllLogins();
					 return loginList;
				 }

		    
		    public List<LoginBean> updateLogin(final LoginBean loginBean) throws SQLException {


		        final String sql = "update login set login_username='" + loginBean.getLoginName() +"',  login_password='" + loginBean.getLoginPassword()+"',  login_role_id=" + loginBean.getLoginRoleId()   + " where login_id=" + loginBean.getLoginId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<LoginBean>)this.fetchAllLogins();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<LoginBean>)this.fetchAllLogins();
		    }
		    
		    public List<LoginBean> deleteLogin(final LoginBean loginBean) throws SQLException {
		        final String sql = "DELETE FROM login WHERE login_id=" + loginBean.getLoginId();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<LoginBean>)this.fetchAllLogins();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<LoginBean>)this.fetchAllLogins();
		    }
		    
}
