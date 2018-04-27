package com.recmgmt.controller;

import com.recmgmt.model.Event;
import com.recmgmt.model.SearchConfig;
import com.recmgmt.model.SearchResult;
import com.recmgmt.service.CourtReservationService;
//import com.recmgmt.service.EventService;
import com.recmgmt.util.CommonDataUtil;
import com.sun.tools.javac.code.Attribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;


/**
 * @author Dixit Patel
 */

@RestController
public class SearchController {
    private Logger logger= LoggerFactory.getLogger(SearchController.class);

    //EventService eventService;

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public SearchResult search(@RequestBody SearchConfig search) {
      /*  logger.info("Searching for events");
        //TODO refactor to search multiple at once
        EventService es = new EventService();
        SearchResult rs = new SearchResult();
        ArrayList<Event> events = new ArrayList<>();
        if (!search.getEventIds().isEmpty()){
            for(int id:search.getEventIds()){
                events.add(eventService.getEventDetails(id));
            }
        }

        rs.setEvents(events);
        return rs;*/
      return null;
    }

    //TODO Refactor searching filterss

    private SearchResult searchByDate(ArrayList<Integer>eventIds,Date date){
        return new SearchResult();
    }
    private SearchResult searchByType(ArrayList<Integer>eventIds,CommonDataUtil.EventType type){
        return new SearchResult();

    }
    private SearchResult searchByName(ArrayList<String>eventNames){
        return new SearchResult();

    }
}


