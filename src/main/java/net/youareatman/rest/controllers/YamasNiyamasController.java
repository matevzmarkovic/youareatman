package net.youareatman.rest.controllers;

import net.youareatman.model.NiyamasEntry;
import net.youareatman.model.YamasEntry;
import net.youareatman.model.forms.*;
import net.youareatman.rest.services.YamasNiyamasService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class YamasNiyamasController {

    @Autowired
    private YamasNiyamasService yamasNiyamasService;

    private static Logger logger = LogManager.getLogger(YamasNiyamasController.class);

    //TODO add exceptions
    //TODO add https

    //TODO proceed to construct PostgreSQL queries with http://javasampleapproach.com/spring-framework/use-spring-jpa-postgresql-spring-boot

    //******************************************************************************************************************
    //                                              Yamas and Niyamas management
    //******************************************************************************************************************

    @RequestMapping(value = "/yamas",method=GET)
    @ResponseBody
    public ResponseEntity<List<YamasEntry>> listAllYamasEntries() {

        yamasNiyamasService.listAllYamasEntries();

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas",method=GET)
    @ResponseBody
    public ResponseEntity<List<NiyamasEntry>> listAllNiyamasEntries() {

        yamasNiyamasService.listAllNiyamasEntries();

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<YamasEntry> listYamasEntriesByUser(@PathVariable( "userEmail" ) String userEmail) {

        yamasNiyamasService.listYamasEntriesByUser(userEmail);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<NiyamasEntry> listNiyamasEntriesByUser(@PathVariable( "userEmail" ) String userEmail) {

        yamasNiyamasService.listNiyamasEntriesByUser(userEmail);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas/{date}",method=GET)
    @ResponseBody
    public ResponseEntity<YamasEntry> listYamasEntriesByDate(@PathVariable( "date" ) Date date) {

        yamasNiyamasService.listYamasEntriesByDate(date);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas/{date}",method=GET)
    @ResponseBody
    public ResponseEntity<NiyamasEntry> listNiyamasEntriesByDate(@PathVariable( "date" ) Date date) {

        yamasNiyamasService.listNiyamasEntriesByDate(date);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas",method=GET)
    @ResponseBody
    public ResponseEntity<YamasEntry> listYamasEntry(@RequestBody YamasEntryForm yamasEntryForm) {

        yamasNiyamasService.listYamasEntry(yamasEntryForm);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas",method=GET)
    @ResponseBody
    public ResponseEntity<NiyamasEntry> listNiyamasEntry(@RequestBody NiyamasEntryForm niyamasEntryForm) {

        yamasNiyamasService.listNiyamasEntry(niyamasEntryForm);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas",method=POST)
    @ResponseBody
    public ResponseEntity createYamasEntry(@RequestBody YamasEntry yamasEntry) {

        yamasNiyamasService.createYamasEntry(yamasEntry);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas",method=POST)
    @ResponseBody
    public ResponseEntity createNiyamasEntry(@RequestBody NiyamasEntry niyamasEntry) {

        yamasNiyamasService.createNiyamasEntry(niyamasEntry);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas",method=PUT)
    @ResponseBody
    public ResponseEntity changeYamasEntry(@RequestBody YamasEntry yamasEntry) {

        yamasNiyamasService.changeYamasEntry(yamasEntry);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas",method=PUT)
    @ResponseBody
    public ResponseEntity changeNiyamasEntry(@RequestBody NiyamasEntry niyamasEntry) {

        yamasNiyamasService.changeNiyamasEntry(niyamasEntry);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/yamas",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteYamasEntry(@RequestBody YamasEntryForm yamasEntryForm) {

        yamasNiyamasService.deleteYamasEntry(yamasEntryForm);

        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/niyamas",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteNiyamasEntry(@RequestBody NiyamasEntryForm niyamasEntryForm) {

        yamasNiyamasService.deleteNiyamasEntry(niyamasEntryForm);

        return ResponseEntity.ok(null);
    }
}
