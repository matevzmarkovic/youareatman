package net.youareatman.rest.controllers;

import net.youareatman.exceptions.GenericYouAreAtmanException;
import net.youareatman.model.*;
import net.youareatman.model.forms.*;
import net.youareatman.rest.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger logger = LogManager.getLogger(UserController.class);

    //TODO add https
    //TODO add better exception handling

    //******************************************************************************************************************
    //                                              User management
    //******************************************************************************************************************

    @RequestMapping(value = "/users",method=GET)
    @ResponseBody
    public ResponseEntity<List<User>> listUsers() {

        List<User> users = userService.listUsers();

        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/users/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<User> listUser(@PathVariable( "userEmail" ) String userEmail) {
        try {
            User user = userService.listUser(userEmail);
            return ResponseEntity.ok(user);
        } catch (GenericYouAreAtmanException e) {
            return (ResponseEntity<User>) ResponseEntity.badRequest();
        }

    }

    @RequestMapping(value = "/users/{userEmail}/password",method=POST)
    @ResponseBody
    public ResponseEntity changeUserPassword(@PathVariable( "userEmail" ) String userEmail,@RequestBody ChangePasswordForm changePasswordForm) {

        try {
            User user = userService.changePassword(userEmail, changePasswordForm);
            return ResponseEntity.ok(user);
        } catch (GenericYouAreAtmanException e) {
            return (ResponseEntity<User>) ResponseEntity.badRequest();
        }
    }

    @RequestMapping(value = "/users/{userEmail}/date",method=POST)
    @ResponseBody
    public ResponseEntity changeUserJoinDate(@PathVariable( "userEmail" ) String userEmail,@RequestBody ChangeDateForm changeDateForm) {

        try{
            User user = userService.changeUserJoinDate(userEmail, changeDateForm);
            return ResponseEntity.ok(user);
        }
        catch(GenericYouAreAtmanException e){
            return (ResponseEntity<User>) ResponseEntity.badRequest();
        }
    }

    @RequestMapping(value = "/users",method=PUT)
    @ResponseBody
    public ResponseEntity createUser(@RequestBody User user) {

        userService.createUser(user);

        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/users/{userEmail}",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteUser(@PathVariable( "userEmail" ) String userEmail) {

        try {
            User user = userService.deleteUser(userEmail);
            return ResponseEntity.ok(user);
        } catch (GenericYouAreAtmanException e) {
            return (ResponseEntity<User>) ResponseEntity.badRequest();
        }

    }

}
