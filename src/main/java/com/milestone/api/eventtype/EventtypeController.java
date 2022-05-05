package com.milestone.api.eventtype;





import com.milestone.api.eventtype.EventtypeBean;
import com.milestone.api.eventtype.EventtypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping({ "/milestone/eventtype" })
public class EventtypeController {


    @Autowired
    com.milestone.api.eventtype.EventtypeDAO EventtypeDAO;

    @RequestMapping(method = { RequestMethod.GET }, value = { "/fetchAllEventtypes" })
    public List<EventtypeBean> fetchAllEventtypes() throws SQLException {
        return (List<EventtypeBean>)this.EventtypeDAO.fetchAllEventtypes();
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/createEventtype" })
    public List<EventtypeBean> createEventtype(@RequestBody final EventtypeBean EventtypeBean) throws SQLException {
        return (List<EventtypeBean>)this.EventtypeDAO.createEventtype(EventtypeBean);
    }
    @RequestMapping(method = { RequestMethod.POST }, value = { "/updateEventtype" })
    public List<EventtypeBean> updateEventtype(@RequestBody final EventtypeBean EventtypeBean) throws SQLException {
        return (List<EventtypeBean>)this.EventtypeDAO.updateEventtype(EventtypeBean);
    }

    @RequestMapping(method = { RequestMethod.POST }, value = { "/deleteEventtype" })
    public List<EventtypeBean> deleteEventtype(@RequestBody final EventtypeBean EventtypeBean) throws SQLException {
        return (List<EventtypeBean>)this.EventtypeDAO.deleteEventtype(EventtypeBean);
    }


    @RequestMapping(method = { RequestMethod.POST }, value = { "/undoEventtype" })
    public List<EventtypeBean> undoEventtype(@RequestBody final EventtypeBean EventtypeBean) throws SQLException {
        return (List<EventtypeBean>)this.EventtypeDAO.undoEventtype(EventtypeBean);
    }


}



