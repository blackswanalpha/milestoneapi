package com.milestone.api.eventtype;






import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.milestone.api.eventtype.EventtypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class EventtypeDAO {
    PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
    public EventtypeDAO() {
        super();
        this.cst = null;
        this.conn = null;
    }

    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "eventtype_id";
        final String table_name = "eventtype";
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




    public List<EventtypeBean> fetchAllEventtypes() throws SQLException {
        final String selectSQL = "SELECT eventtype_id,eventtype_name,eventtype_img,eventtype_desc, eventtype_venue_id, eventtype_cost,eventtype_company_id	 FROM eventtype,company  where not eventtype_status_id = 2 and  eventtype_company_id =company_id  ";
        final List<EventtypeBean>eventtypeList = new ArrayList<EventtypeBean>();
        try {
            this.conn = this.dataSource.getConnection();
            this.cst = this.conn.prepareStatement(selectSQL);
            final ResultSet rs = this.cst.executeQuery();
            while (rs.next()) {
                final EventtypeBean eventtype = new EventtypeBean();
                eventtype.setEventtypeId(rs.getInt("eventtype_id"));

                eventtype.setEventtypeName(rs.getString("eventtype_name"));
                eventtype.setEventtypeImg(rs.getString("eventtype_img"));
                eventtype.setEventtypeDesc(rs.getString("eventtype_desc"));
                eventtype.setEventtypeVenueId(rs.getInt("eventtype_venue_id"));
              //  eventtype.setEventtypeContact(rs.getInt("eventtype_contact"));
                eventtype.setEventtypeCost(rs.getFloat("eventtype_cost"));
                eventtype.setEventtypeCompanyId(rs.getInt("eventtype_company_id"));


                eventtypeList.add(eventtype);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return eventtypeList;
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return eventtypeList;
    }
    public List<EventtypeBean> createEventtype(final EventtypeBean eventtypeBean) throws SQLException {
        final String selectSQL = "INSERT INTO eventtype(eventtype_id,eventtype_name,eventtype_img,eventtype_venue_id,eventtype_desc, eventtype_cost,eventtype_company_id,eventtype_status_id) values(" + this.getNextPrimaryKey() + ", '" + eventtypeBean.getEventtypeName() +  "', '"+eventtypeBean.getEventtypeImg()+ "', " + eventtypeBean.getEventtypeVenueId()  +  ", '" + eventtypeBean.getEventtypeDesc() +  "', " + eventtypeBean.getEventtypeCost() +  ", " + eventtypeBean.getEventtypeCompanyId() +  ",1);";
        List<EventtypeBean>eventtypeList = new ArrayList<EventtypeBean>();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<EventtypeBean>)this.fetchAllEventtypes();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        eventtypeList = (List<EventtypeBean>)this.fetchAllEventtypes();
        return eventtypeList;
    }

    public List<EventtypeBean> updateEventtype(final EventtypeBean eventtypeBean) throws SQLException {
        final String sql = "update eventtype set eventtype_name='" + eventtypeBean.getEventtypeName() +"', eventtype_company_id=" +eventtypeBean.getEventtypeCompanyId()+",eventtype_cost="+eventtypeBean.getEventtypeCost() +",eventtype_venue_id="+eventtypeBean.getEventtypeVenueId() +",eventtype_desc='"+eventtypeBean.getEventtypeDesc() +"',eventtype_img='"+eventtypeBean.getEventtypeImg()+ "' where eventtype_id=" +eventtypeBean.getEventtypeId();
        System.out.println(sql);
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<EventtypeBean>)this.fetchAllEventtypes();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<EventtypeBean>)this.fetchAllEventtypes();
    }

    public List<EventtypeBean> deleteEventtype(final EventtypeBean eventtypeBean) throws SQLException {
        final String sql = "update eventtype set eventtype_status_id = 2  WHERE eventtype_id=" +eventtypeBean.getEventtypeId();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<EventtypeBean>)this.fetchAllEventtypes();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<EventtypeBean>)this.fetchAllEventtypes();
    }

    public List<EventtypeBean> undoEventtype(EventtypeBean eventtypeBean) throws SQLException {
        final String sql = "update eventtype set eventtype_status_id = 1  WHERE eventtype_id=" + eventtypeBean.getEventtypeId();

        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<EventtypeBean>)this.fetchAllEventtypes();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<EventtypeBean>)this.fetchAllEventtypes();
    }

}



