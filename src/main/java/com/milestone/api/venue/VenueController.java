package com.milestone.api.venue;



import com.milestone.api.venue.VenueBean;
import com.milestone.api.venue.VenueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping({ "/milestone/venue" })
public class VenueController {


    @Autowired
    com.milestone.api.venue.VenueDAO VenueDAO;

    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllVenues" })
    public List<VenueBean> fetchAllVenues() throws SQLException {
        return (List<VenueBean>)this.VenueDAO.fetchAllVenues();
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/createVenue" })
    public List<VenueBean> createVenue(@RequestBody final VenueBean VenueBean) throws SQLException {
        return (List<VenueBean>)this.VenueDAO.createVenue(VenueBean);
    }
    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateVenue" })
    public List<VenueBean> updateVenue(@RequestBody final VenueBean VenueBean) throws SQLException {
        return (List<VenueBean>)this.VenueDAO.updateVenue(VenueBean);
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteVenue" })
    public List<VenueBean> deleteVenue(@RequestBody final VenueBean VenueBean) throws SQLException {
        return (List<VenueBean>)this.VenueDAO.deleteVenue(VenueBean);
    }


    @RequestMapping(method = { RequestMethod.POST }, value = { "/undoVenue" })
    public List<VenueBean> undoVenue(@RequestBody final VenueBean VenueBean) throws SQLException {
        return (List<VenueBean>)this.VenueDAO.undoVenue(VenueBean);
    }


}


