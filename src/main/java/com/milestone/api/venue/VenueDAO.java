package com.milestone.api.venue;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.milestone.api.venue.VenueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class VenueDAO {
    PreparedStatement cst;
    Connection conn;
    @Autowired
    DataSource dataSource;
    public VenueDAO() {
        super();
        this.cst = null;
        this.conn = null;
    }

    public int getNextPrimaryKey() throws SQLException {
        final String column_name = "venue_id";
        final String table_name = "venue";
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




    public List<VenueBean> fetchAllVenues() throws SQLException {
        final String selectSQL = "SELECT venue_id,venue_name,venue_img,venue_capacity, venue_contact,venue_location, venue_cost,venue_company_id	 FROM venue,company  where not venue_status_id = 2 and  venue_company_id =company_id  ";
        final List<VenueBean>venueList = new ArrayList<VenueBean>();
        try {
            this.conn = this.dataSource.getConnection();
            this.cst = this.conn.prepareStatement(selectSQL);
            final ResultSet rs = this.cst.executeQuery();
            while (rs.next()) {
                final VenueBean venue = new VenueBean();
                venue.setVenueId(rs.getInt("venue_id"));

                venue.setVenueName(rs.getString("venue_name"));
                venue.setVenueImg(rs.getString("venue_img"));
                venue.setVenueLocation(rs.getString("venue_location"));
                venue.setVenueCapacity(rs.getInt("venue_capacity"));
                venue.setVenueContact(rs.getInt("venue_contact"));
                venue.setVenueCost(rs.getInt("venue_cost"));
                venue.setVenueCompanyId(rs.getInt("venue_company_id"));


                venueList.add(venue);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return venueList;
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return venueList;
    }
    public List<VenueBean> createVenue(final VenueBean venueBean) throws SQLException {
        final String selectSQL = "INSERT INTO venue(venue_id,venue_name,venue_img,venue_capacity, venue_contact,venue_location, venue_cost,venue_company_id,venue_status_id) values(" + this.getNextPrimaryKey() + ", '" + venueBean.getVenueName() +  "', '"+venueBean.getVenueImg()+ "', " + venueBean.getVenueCapacity() +   ", " + venueBean.getVenueContact() +  ", '" + venueBean.getVenueLocation() +  "', " + venueBean.getVenueCost() +  ", " + venueBean.getVenueCompanyId() +  ",1);";
        List<VenueBean>venueList = new ArrayList<VenueBean>();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(selectSQL)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<VenueBean>)this.fetchAllVenues();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        venueList = (List<VenueBean>)this.fetchAllVenues();
        return venueList;
    }

    public List<VenueBean> updateVenue(final VenueBean venueBean) throws SQLException {
        final String sql = "update venue set venue_name='" + venueBean.getVenueName() +"', venue_company_id=" +venueBean.getVenueCompanyId()+", venue_contact=" +venueBean.getVenueContact()+",venue_cost="+venueBean.getVenueCost() +",venue_capacity="+venueBean.getVenueCapacity() +",venue_location='"+venueBean.getVenueLocation() +"',venue_img='"+venueBean.getVenueImg()+ "' where venue_id=" +venueBean.getVenueId();
        System.out.println(sql);
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<VenueBean>)this.fetchAllVenues();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<VenueBean>)this.fetchAllVenues();
    }

    public List<VenueBean> deleteVenue(final VenueBean venueBean) throws SQLException {
        final String sql = "update venue set venue_status_id = 2  WHERE venue_id=" +venueBean.getVenueId();
        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<VenueBean>)this.fetchAllVenues();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<VenueBean>)this.fetchAllVenues();
    }

    public List<VenueBean> undoVenue(VenueBean venueBean) throws SQLException {
        final String sql = "update venue set venue_status_id = 1  WHERE venue_id=" + venueBean.getVenueId();

        try {
            this.conn = this.dataSource.getConnection();
            (this.cst = this.conn.prepareStatement(sql)).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return (List<VenueBean>)this.fetchAllVenues();
        }
        finally {
            this.conn.close();
        }
        this.conn.close();
        return (List<VenueBean>)this.fetchAllVenues();
    }

}


