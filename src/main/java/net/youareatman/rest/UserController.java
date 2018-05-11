package net.youareatman.rest;

import net.youareatman.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {

    private static Logger logger = LogManager.getLogger(UserController.class);

    //TODO add exceptions
    //TODO add https

    //******************************************************************************************************************
    //                                              User management
    //******************************************************************************************************************

    @RequestMapping(value = "/users",method=GET)
    @ResponseBody
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/users/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<User> listUser(@PathVariable( "userEmail" ) String userEmail) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/users/{userEmail}/password",method=PUT)
    @ResponseBody
    public ResponseEntity changeUserPassword(@PathVariable( "userEmail" ) String userEmail,@RequestBody ChangePasswordForm changePasswordForm) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/users/{userEmail}/date",method=PUT)
    @ResponseBody
    public ResponseEntity changeUserJoinDate(@PathVariable( "userEmail" ) String userEmail,@RequestBody ChangeDateForm changeDateForm) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/users/{userEmail}",method=POST)
    @ResponseBody
    public ResponseEntity createUser(@PathVariable( "userEmail" ) String userEmail,@RequestBody User user) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/users/{userEmail}",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteUser(@PathVariable( "userEmail" ) String userEmail) {
        return ResponseEntity.ok(null);
    }

    //******************************************************************************************************************
    //                                              Yamas and Niyamas management
    //******************************************************************************************************************

    @RequestMapping(value = "/yamas",method=GET)
    @ResponseBody
    public ResponseEntity<List<YamasEntry>> listAllYamasEntries() {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas",method=GET)
    @ResponseBody
    public ResponseEntity<List<NiyamasEntry>> listAllNiyamasEntries() {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<YamasEntry> listYamasEntriesByUser(@PathVariable( "userEmail" ) String userEmail) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<NiyamasEntry> listNiyamasEntriesByUser(@PathVariable( "userEmail" ) String userEmail) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas/{date}",method=GET)
    @ResponseBody
    public ResponseEntity<YamasEntry> listYamasEntriesByDate(@PathVariable( "date" ) Date date) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas/{date}",method=GET)
    @ResponseBody
    public ResponseEntity<NiyamasEntry> listNiyamasEntriesByDate(@PathVariable( "date" ) Date date) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas",method=GET)
    @ResponseBody
    public ResponseEntity<YamasEntry> listYamasEntry(@RequestBody YamasEntryForm yamasEntryForm) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas",method=GET)
    @ResponseBody
    public ResponseEntity<NiyamasEntry> listNiyamasEntry(@RequestBody NiyamasEntryForm niyamasEntryForm) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas",method=POST)
    @ResponseBody
    public ResponseEntity createYamasEntry(@RequestBody YamasEntry yamasEntry) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas",method=POST)
    @ResponseBody
    public ResponseEntity createNiyamasEntry(@RequestBody NiyamasEntry niyamasEntry) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas",method=PUT)
    @ResponseBody
    public ResponseEntity changeYamasEntry(@RequestBody YamasEntry yamasEntry) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas",method=PUT)
    @ResponseBody
    public ResponseEntity changeNiyamasEntry(@RequestBody NiyamasEntry niyamasEntry) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteYamasEntry(@RequestBody YamasEntryForm yamasEntryForm) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteNiyamasEntry(@RequestBody NiyamasEntryForm niyamasEntryForm) {
        return ResponseEntity.ok(null);
    }

    //******************************************************************************************************************
    //                                              Incident management
    //******************************************************************************************************************

    @RequestMapping(value = "/incident",method=GET)
    @ResponseBody
    public ResponseEntity<List<IncidentEntry>> listIncidentEntries() {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incident/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<IncidentEntry> listIncidentEntriesByUser(@PathVariable( "userEmail" ) String userEmail) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incident/{date}",method=GET)
    @ResponseBody
    public ResponseEntity<IncidentEntry> listIncidentEntriesByDate(@PathVariable( "date" ) Date date) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incident/{incidentId}",method=GET)
    @ResponseBody
    public ResponseEntity<IncidentEntry> listIncidentEntry(@PathVariable( "incidentId" ) String incidentId) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incident/{incidentId}",method=PUT)
    @ResponseBody
    public ResponseEntity changeIncidentEntry(@PathVariable( "incidentId" ) String incidentId, @RequestBody IncidentEntryForm incidentEntryForm) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incident/{incidentId}",method=POST)
    @ResponseBody
    public ResponseEntity createIncidentEntry(@PathVariable( "incidentId" ) String incidentId, @RequestBody IncidentEntryForm incidentEntryForm) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/incident/{incidentId}",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteIncidentEntry(@PathVariable( "incidentId" ) String incidentId) {
        return ResponseEntity.ok(null);
    }

}
