package com.milestone.api.role;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class RoleDAO {
    PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
    public RoleDAO() {
        super();
        this.cst = null;
        this.conn = null;
    }

    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "role_id";
        final String table_name = "role";
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




    public List<RoleBean> fetchAllUsers() throws SQLException {
        final String selectSQL = "SELECT role_id,role_name FROM role";
        final List<RoleBean> userList = new ArrayList<RoleBean>();
        try {
            this.conn = this.dataSource.getConnection();
            this.cst = this.conn.prepareStatement(selectSQL);
            final ResultSet rs = this.cst.executeQuery();
            while (rs.next()) {
                final RoleBean user = new RoleBean();
                user.setRoleId(rs.getInt("role_id"));
                user.setRoleName(rs.getString("role_name"));

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
    public List<RoleBean> createUser(final RoleBean userBean) throws SQLException {
        final String selectSQL = "INSERT INTO role (role_id, role_name) values(" + this.getNextPrimaryKey() + ", '" + userBean.getRoleName() +  "');";
        List<RoleBean> userList = new ArrayList<RoleBean>();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<RoleBean>)this.fetchAllUsers();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        userList = (List<RoleBean>)this.fetchAllUsers();
        return userList;
    }

    public List<RoleBean> updateGroup(final RoleBean groupBean) throws SQLException {
        final String sql = "update role set role_name='" + groupBean.getRoleName() + "'" + " where role_id=" + groupBean.getRoleId();
        System.out.println(sql);
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<RoleBean>)this.fetchAllUsers();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<RoleBean>)this.fetchAllUsers();
    }

    public List<RoleBean> deleteGroup(final RoleBean groupBean) throws SQLException {
        final String sql = "DELETE FROM role WHERE role_id=" + groupBean.getRoleId();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<RoleBean>)this.fetchAllUsers();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<RoleBean>)this.fetchAllUsers();
    }




}

