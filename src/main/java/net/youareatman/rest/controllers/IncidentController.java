package net.youareatman.rest.controllers;

import net.youareatman.exceptions.GenericYouAreAtmanException;
import net.youareatman.exceptions.IncidentManagementException;
import net.youareatman.model.IncidentEntry;
import net.youareatman.model.forms.*;
import net.youareatman.rest.services.IncidentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    //TODO add https

    //******************************************************************************************************************
    //                                              Incident management
    //******************************************************************************************************************

    @RequestMapping(value = "/incidents",method=GET)
    @ResponseBody
    public ResponseEntity<List<IncidentEntry>> listIncidentEntries() {
        return ResponseEntity.ok(incidentService.listIncidentEntries());
    }

    @RequestMapping(value = "/incidents/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<List<IncidentEntry>> listIncidentEntriesByUser(@PathVariable( "userEmail" ) String userEmail) {

        try {
            return ResponseEntity.ok(incidentService.listIncidentEntriesByUser(userEmail));
        } catch (IncidentManagementException e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @RequestMapping(value = "/incidents/{date}",method=GET)
    @ResponseBody
    public ResponseEntity<List<IncidentEntry>> listIncidentEntriesByDate(@PathVariable( "date" ) Date date) {

        try {
            return ResponseEntity.ok(incidentService.listIncidentEntriesByDate(date));
        } catch (IncidentManagementException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/incidents/{incidentId}",method=GET)
    @ResponseBody
    public ResponseEntity<IncidentEntry> listIncidentEntry(@PathVariable( "incidentId" ) String incidentId) {

        try {
            return ResponseEntity.ok(incidentService.listIncidentEntry(incidentId));
        } catch (GenericYouAreAtmanException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/incidents",method=POST)
    @ResponseBody
    public ResponseEntity createIncidentEntry(@RequestBody IncidentEntry incidentEntry) {

        return ResponseEntity.ok(incidentService.createIncidentEntry(incidentEntry));
    }

    @RequestMapping(value = "/incidents/{incidentId}",method=PUT)
    @ResponseBody
    public ResponseEntity changeIncident(@PathVariable( "incidentId" ) String incidentId, @RequestBody IncidentEntryForm incidentEntryForm) {

        try {
            return ResponseEntity.ok(incidentService.changeIncidentEntry(incidentId, incidentEntryForm));
        } catch (IncidentManagementException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/incidents/{incidentId}",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteIncidentEntry(@PathVariable( "incidentId" ) String incidentId) {

        try {
            incidentService.deleteIncidentEntry(incidentId);
            return ResponseEntity.ok().build();
        } catch (IncidentManagementException e) {
            return ResponseEntity.badRequest().build();
        }

    }

}
