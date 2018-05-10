package net.youareatman.rest;

import net.youareatman.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {

    private static Logger logger = LogManager.getLogger(UserController.class);

    //TODO add response - http status and body
    //TODO add exceptions
    //TODO add https

    //******************************************************************************************************************
    //                                              User management
    //******************************************************************************************************************

    @RequestMapping(value = "/users",method=GET)
    @ResponseBody
    public List<User> listUsers() {
        return null;
    }

    @RequestMapping(value = "/users/{userEmail}",method=GET)
    @ResponseBody
    public User listUser(@PathVariable( "userEmail" ) String userEmail) {
        return null;
    }

    @RequestMapping(value = "/users/{userEmail}/password",method=PUT)
    @ResponseBody
    public void changeUserPassword(@PathVariable( "userEmail" ) String userEmail,@RequestBody ChangePasswordForm changePasswordForm) {

    }

    @RequestMapping(value = "/users/{userEmail}/date",method=PUT)
    @ResponseBody
    public void changeUserJoinDate(@PathVariable( "userEmail" ) String userEmail,@RequestBody ChangeDateForm changeDateForm) {

    }

    @RequestMapping(value = "/users/{userEmail}",method=POST)
    @ResponseBody
    public void createUser(@PathVariable( "userEmail" ) String userEmail,@RequestBody User user) {

    }

    @RequestMapping(value = "/users/{userEmail}",method=DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable( "userEmail" ) String userEmail) {

    }

    //******************************************************************************************************************
    //                                              Yamas and Niyamas management
    //******************************************************************************************************************

    @RequestMapping(value = "/yamas",method=GET)
    @ResponseBody
    public List<YamasEntry> listAllYamasEntries() {
        return null;
    }

    @RequestMapping(value = "/niyamas",method=GET)
    @ResponseBody
    public List<NiyamasEntry> listAllNiyamasEntries() {
        return null;
    }

    @RequestMapping(value = "/yamas/{userEmail}",method=GET)
    @ResponseBody
    public YamasEntry listYamasEntriesByUser(@PathVariable( "userEmail" ) String userEmail) {
        return null;
    }

    @RequestMapping(value = "/niyamas/{userEmail}",method=GET)
    @ResponseBody
    public NiyamasEntry listNiyamasEntriesByUser(@PathVariable( "userEmail" ) String userEmail) {
        return null;
    }

    @RequestMapping(value = "/yamas/{date}",method=GET)
    @ResponseBody
    public YamasEntry listYamasEntriesByDate(@PathVariable( "date" ) Date date) {
        return null;
    }

    @RequestMapping(value = "/niyamas/{date}",method=GET)
    @ResponseBody
    public NiyamasEntry listNiyamasEntriesByDate(@PathVariable( "date" ) Date date) {
        return null;
    }

    @RequestMapping(value = "/yamas",method=GET)
    @ResponseBody
    public YamasEntry listYamasEntry(@RequestBody YamasEntryForm yamasEntryForm) {
        return null;
    }

    @RequestMapping(value = "/niyamas",method=GET)
    @ResponseBody
    public NiyamasEntry listNiyamasEntry(@RequestBody NiyamasEntryForm niyamasEntryForm) {
        return null;
    }

    @RequestMapping(value = "/yamas",method=POST)
    @ResponseBody
    public void createYamasEntry(@RequestBody YamasEntry yamasEntry) {

    }

    @RequestMapping(value = "/niyamas",method=POST)
    @ResponseBody
    public void createNiyamasEntry(@RequestBody NiyamasEntry niyamasEntry) {

    }

    @RequestMapping(value = "/yamas",method=PUT)
    @ResponseBody
    public void changeYamasEntry(@RequestBody YamasEntry yamasEntry) {

    }

    @RequestMapping(value = "/niyamas",method=PUT)
    @ResponseBody
    public void changeNiyamasEntry(@RequestBody NiyamasEntry niyamasEntry) {

    }

    @RequestMapping(value = "/yamas",method=DELETE)
    @ResponseBody
    public void deleteYamasEntry(@RequestBody YamasEntryForm yamasEntryForm) {

    }

    @RequestMapping(value = "/niyamas",method=DELETE)
    @ResponseBody
    public void deleteNiyamasEntry(@RequestBody NiyamasEntryForm niyamasEntryForm) {

    }

    //******************************************************************************************************************
    //                                              Incident management
    //******************************************************************************************************************

    @RequestMapping(value = "/incident",method=GET)
    @ResponseBody
    public List<IncidentEntry> listIncidentEntries() {
        return null;
    }

    @RequestMapping(value = "/incident/{userEmail}",method=GET)
    @ResponseBody
    public IncidentEntry listIncidentEntriesByUser(@PathVariable( "userEmail" ) String userEmail) {
        return null;
    }

    @RequestMapping(value = "/incident/{date}",method=GET)
    @ResponseBody
    public IncidentEntry listIncidentEntriesByDate(@PathVariable( "date" ) Date date) {
        return null;
    }

    @RequestMapping(value = "/incident/{incidentId}",method=GET)
    @ResponseBody
    public IncidentEntry listIncidentEntry(@PathVariable( "incidentId" ) String incidentId) {
        return null;
    }

    @RequestMapping(value = "/incident/{incidentId}",method=PUT)
    @ResponseBody
    public void changeIncidentEntry(@PathVariable( "incidentId" ) String incidentId, @RequestBody IncidentEntryForm incidentEntryForm) {

    }

    @RequestMapping(value = "/incident/{incidentId}",method=POST)
    @ResponseBody
    public void createIncidentEntry(@PathVariable( "incidentId" ) String incidentId, @RequestBody IncidentEntryForm incidentEntryForm) {

    }

    @RequestMapping(value = "/incident/{incidentId}",method=DELETE)
    @ResponseBody
    public void deleteIncidentEntry(@PathVariable( "incidentId" ) String incidentId) {

    }

}
