package net.youareatman.rest;

import net.youareatman.model.*;
import net.youareatman.model.forms.*;
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

    //TODO proceed to construct PostgreSQL queries with http://javasampleapproach.com/spring-framework/use-spring-jpa-postgresql-spring-boot

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

}
