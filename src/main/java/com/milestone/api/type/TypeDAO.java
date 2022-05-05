package com.milestone.api.type;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.milestone.api.type.TypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class TypeDAO {
    PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
    public TypeDAO() {
        super();
        this.cst = null;
        this.conn = null;
    }

    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "type_id";
        final String table_name = "type";
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




    public List<TypeBean> fetchAllUsers() throws SQLException {
        final String selectSQL = "SELECT type_id,type_name FROM type";
        final List<TypeBean> userList = new ArrayList<TypeBean>();
        try {
            this.conn = this.dataSource.getConnection();
            this.cst = this.conn.prepareStatement(selectSQL);
            final ResultSet rs = this.cst.executeQuery();
            while (rs.next()) {
                final TypeBean user = new TypeBean();
                user.setTypeId(rs.getInt("type_id"));
                user.setTypeName(rs.getString("type_name"));

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
    public List<TypeBean> createUser(final TypeBean userBean) throws SQLException {
        final String selectSQL = "INSERT INTO type (type_id, type_name) values(" + this.getNextPrimaryKey() + ", '" + userBean.getTypeName() +  "');";
        List<TypeBean> userList = new ArrayList<TypeBean>();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<TypeBean>)this.fetchAllUsers();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        userList = (List<TypeBean>)this.fetchAllUsers();
        return userList;
    }

    public List<TypeBean> updateGroup(final TypeBean groupBean) throws SQLException {
        final String sql = "update type set type_name='" + groupBean.getTypeName() + "'" + " where type_id=" + groupBean.getTypeId();
        System.out.println(sql);
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<TypeBean>)this.fetchAllUsers();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<TypeBean>)this.fetchAllUsers();
    }

    public List<TypeBean> deleteGroup(final TypeBean groupBean) throws SQLException {
        final String sql = "DELETE FROM type WHERE type_id=" + groupBean.getTypeId();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<TypeBean>)this.fetchAllUsers();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<TypeBean>)this.fetchAllUsers();
    }




}

