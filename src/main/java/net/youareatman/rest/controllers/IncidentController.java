package net.youareatman.rest.controllers;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.GenericYouAreAtmanException;
import net.youareatman.exceptions.IncidentManagementException;
import net.youareatman.model.IncidentEntry;
import net.youareatman.model.forms.*;
import net.youareatman.rest.services.IncidentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
            return new ResponseEntity(incidentService.listIncidentEntriesByUser(userEmail), HttpStatus.OK);
        } catch (IncidentManagementException e) {
            return processIncidentManagementException(e);
        }

    }

    @RequestMapping(value = "/incidents/{date}",method=GET)
    @ResponseBody
    public ResponseEntity<List<IncidentEntry>> listIncidentEntriesByDate(@PathVariable( "date" ) Date date) {

        try {
            return new ResponseEntity(incidentService.listIncidentEntriesByDate(date), HttpStatus.OK);
        } catch (IncidentManagementException e) {
            return processIncidentManagementException(e);
        }
    }

    @RequestMapping(value = "/incidents/{incidentId}",method=GET)
    @ResponseBody
    public ResponseEntity<IncidentEntry> listIncidentEntry(@PathVariable( "incidentId" ) String incidentId) {
        try {
            return new ResponseEntity(incidentService.listIncidentEntry(incidentId), HttpStatus.OK);
        } catch (IncidentManagementException e) {
            return processIncidentManagementException(e);
        }
    }

    @RequestMapping(value = "/incidents",method=POST)
    @ResponseBody
    public ResponseEntity<IncidentEntry> createIncidentEntry(@RequestBody IncidentEntry incidentEntry) {
        return new ResponseEntity(incidentService.createIncidentEntry(incidentEntry), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/incidents/{incidentId}",method=PUT)
    @ResponseBody
    public ResponseEntity<IncidentEntry> changeIncident(@PathVariable( "incidentId" ) String incidentId, @RequestBody IncidentEntryForm incidentEntryForm) {
        try {
            return new ResponseEntity(incidentService.changeIncidentEntry(incidentId, incidentEntryForm),HttpStatus.OK);
        } catch (IncidentManagementException e) {
            return processIncidentManagementException(e);
        }
    }

    @RequestMapping(value = "/incidents/{incidentId}",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteIncidentEntry(@PathVariable( "incidentId" ) String incidentId) {

        try {
            incidentService.deleteIncidentEntry(incidentId);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (IncidentManagementException e) {
            return processIncidentManagementException(e);
        }
    }

    /**
     * Generate response in accordance with the nature of exception that occurred.
     * @param e the exception that occurred
     * @return Response entity with the correct HttpStatus code
     */
    private ResponseEntity processIncidentManagementException(IncidentManagementException e) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("error_message",e.getMessage());

        ErrorTypesEnum errorType = e.getErrorType();
        if (errorType.equals(ErrorTypesEnum.IncidentNotFoundError)){
            return new ResponseEntity(httpHeaders,HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(httpHeaders,HttpStatus.BAD_REQUEST);
        }
    }

}
