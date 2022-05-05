package com.milestone.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDAO {
	 PreparedStatement cst;
	    Connection conn;
	    @Autowired
	    DataSource dataSource;
		public UserDAO() {
			super();
			  this.cst = null;
		        this.conn = null;
		}
		
	    public int getNextPrimaryKey() throws SQLException {
	        final String column_name = "user_id";
	        final String table_name = "user";
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



	public  UserBean  findByUserName(String userName) throws SQLException {
		final String selectSQL = "SELECT user_id,user_full_name,user_department_id,user_email,user_mobile,user_login_id,user_imageUrl,login_id,login_username	 FROM user,login where user_login_id =login_id and login_username =  '"+ userName+"'";
//		final List<UserBean>userList = new ArrayList<UserBean>();
		final UserBean user = new UserBean();
		ResultSet rs = null;
		try {
			this.conn = this.dataSource.getConnection();
			this.cst = this.conn.prepareStatement(selectSQL);
		 rs = this.cst.executeQuery();
			while (rs.next()) {

				user.setUserId(rs.getInt("user_id"));

				user.setUserFullName(rs.getString("user_full_name"));
				//user.setUserDepartmentId(rs.getInt("user_department_id"));
				user.setUserEmail(rs.getString("user_email"));
				user.setUserimageUrl(rs.getString("user_imageUrl"));
				user.setLoginUserName(rs.getString("login_username"));
				user.setUserMobile(rs.getInt("user_mobile"));
				user.setUserLoginId(rs.getInt("user_login_id"));
rs.close();


			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return user;
		}
		finally {
			this.conn.close();
		}
		this.conn.close();
		return user;
	}




	public List<UserBean> fetchAllUsers() throws SQLException {
		        final String selectSQL = "SELECT user_id,user_full_name,user_email,user_mobile,user_login_id,user_imageUrl	 FROM user";
		        final List<UserBean>userList = new ArrayList<UserBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            this.cst = this.conn.prepareStatement(selectSQL);
		            final ResultSet rs = this.cst.executeQuery();
		            while (rs.next()) {
		                final UserBean user = new UserBean();
		               user.setUserId(rs.getInt("user_id"));
		                
		               user.setUserFullName(rs.getString("user_full_name"));
		              // user.setUserDepartmentId(rs.getInt("user_department_id"));
		               user.setUserEmail(rs.getString("user_email"));
						user.setUserimageUrl(rs.getString("user_imageUrl"));
	             
		               user.setUserMobile(rs.getInt("user_mobile"));
		               user.setUserLoginId(rs.getInt("user_login_id"));
		                
		               
		               userList.add(user);
		            }
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return userList;
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return userList;
		    }



		    public List<UserBean> createUser(final UserBean userBean) throws SQLException {
		        final String selectSQL = "INSERT INTO user(user_id,user_full_name,user_email,user_mobile,user_login_id,user_imageUrl) values(" + this.getNextPrimaryKey() + ", '" + userBean.getUserFullName() +  "', '"  +userBean.getUserEmail() +  "', "  +userBean.getUserMobile()+", "  +userBean.getUserLoginId()+  ",'https://bootdey.com/img/Content/avatar/avatar1.png');";
		        List<UserBean>userList = new ArrayList<UserBean>();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<UserBean>)this.fetchAllUsers();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		       userList = (List<UserBean>)this.fetchAllUsers();
		        return userList;
		    }
		    
		    public List<UserBean> updateUser(final UserBean userBean) throws SQLException {
		        final String sql = "update user set user_full_name='" + userBean.getUserFullName() +"', user_email='"+userBean.getUserEmail() +"', user_mobile=" +userBean.getUserMobile()+", user_login_id=" +userBean.getUserLoginId() +", user_imageUrl='"+userBean.getUserimageUrl() + "' where user_id=" +userBean.getUserId();
		        System.out.println(sql);
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<UserBean>)this.fetchAllUsers();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<UserBean>)this.fetchAllUsers();
		    }
		    
		    public List<UserBean> deleteUser(final UserBean userBean) throws SQLException {
		        final String sql = "DELETE FROM user WHERE user_id=" +userBean.getUserId();
		        try {
		            this.conn = this.dataSource.getConnection();
		            (this.cst = this.conn.prepareStatement(sql)).execute();
		        }
		        catch (Exception e) {
		            e.printStackTrace();
		            return (List<UserBean>)this.fetchAllUsers();
		        }
		        finally {
		            this.conn.close();
		        }
		        this.conn.close();
		        return (List<UserBean>)this.fetchAllUsers();
		    }
		    
	

}
