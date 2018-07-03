package net.youareatman.rest.controllers;

import net.youareatman.model.IncidentEntry;
import net.youareatman.model.forms.*;
import net.youareatman.rest.services.IncidentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    private static Logger logger = LogManager.getLogger(IncidentController.class);

    //TODO add exceptions
    //TODO add https

    //TODO proceed to construct PostgreSQL queries with http://javasampleapproach.com/spring-framework/use-spring-jpa-postgresql-spring-boot

    //******************************************************************************************************************
    //                                              Incident management
    //******************************************************************************************************************

    @RequestMapping(value = "/incidents",method=GET)
    @ResponseBody
    public ResponseEntity<List<IncidentEntry>> listIncidentEntries() {

        incidentService.listIncidentEntries();

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incidents/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<List<IncidentEntry>> listIncidentEntriesByUser(@PathVariable( "userEmail" ) String userEmail) {

        incidentService.listIncidentEntriesByUser(userEmail);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incidents/{date}",method=GET)
    @ResponseBody
    public ResponseEntity<List<IncidentEntry>> listIncidentEntriesByDate(@PathVariable( "date" ) Date date) {

        incidentService.listIncidentEntriesByDate(date);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incidents/{incidentId}",method=GET)
    @ResponseBody
    public ResponseEntity<IncidentEntry> listIncidentEntry(@PathVariable( "incidentId" ) String incidentId) {

        incidentService.listIncidentEntry(incidentId);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incidents",method=POST)
    @ResponseBody
    public ResponseEntity createIncidentEntry(@RequestBody IncidentEntry incidentEntry) {

        incidentService.createIncidentEntry(incidentEntry);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incidents/{incidentId}",method=PUT)
    @ResponseBody
    public ResponseEntity changeIncidentEntry(@PathVariable( "incidentId" ) String incidentId, @RequestBody IncidentEntry incidentEntry) {

        incidentService.changeIncidentEntry(incidentId, incidentEntry);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incidents/{incidentId}",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteIncidentEntry(@PathVariable( "incidentId" ) String incidentId) {

        incidentService.deleteIncidentEntry(incidentId);

        return ResponseEntity.ok(null);
    }

}
