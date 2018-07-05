package net.youareatman.rest.controllers;

import net.youareatman.exceptions.GenericYouAreAtmanException;
import net.youareatman.exceptions.UserManagementException;
import net.youareatman.helpers.YouAreAtmanHelpers;
import net.youareatman.model.*;
import net.youareatman.model.forms.*;
import net.youareatman.rest.services.AtmanUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.youareatman.helpers.YouAreAtmanHelpers.hashPassword;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class AtmanUserController {

    @Autowired
    private AtmanUserService atmanUserService;

    private static Logger logger = LogManager.getLogger(AtmanUserController.class);

    //TODO add https
    //TODO add better exception handling

    //******************************************************************************************************************
    //                                              User management
    //******************************************************************************************************************

    @RequestMapping(value = "/atmanusers",method=GET)
    @ResponseBody
    public ResponseEntity<List<AtmanUser>> listUsers() {
        List<AtmanUser> users = atmanUserService.listUsers();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/atmanusers/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<AtmanUser> listUser(@PathVariable( "userEmail" ) String userEmail) {
        try {
            AtmanUser user = atmanUserService.listUser(userEmail);
            return ResponseEntity.ok(user);
        } catch (GenericYouAreAtmanException e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @RequestMapping(value = "/atmanusers/{userEmail}/password",method=PUT)
    @ResponseBody
    public ResponseEntity changeUserPassword(@PathVariable( "userEmail" ) String userEmail,@RequestBody ChangePasswordForm changePasswordForm) {

        try {
            AtmanUser user = atmanUserService.changePassword(userEmail, changePasswordForm);
            return ResponseEntity.ok(user);
        } catch (GenericYouAreAtmanException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/atmanusers/{userEmail}/date",method=PUT)
    @ResponseBody
    public ResponseEntity changeUserJoinDate(@PathVariable( "userEmail" ) String userEmail,@RequestBody ChangeDateForm changeDateForm) {

        try{
            AtmanUser user = atmanUserService.changeUserJoinDate(userEmail, changeDateForm);
            return ResponseEntity.ok(user);
        }
        catch(GenericYouAreAtmanException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/atmanusers/{userEmail}",method=POST)
    @ResponseBody
    public ResponseEntity createUser(@PathVariable( "userEmail" ) String userEmail, @RequestBody String password) {
        try {
            AtmanUser user = atmanUserService.createUser(userEmail, password);
            return ResponseEntity.ok(user);
        } catch (UserManagementException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/atmanusers/{userEmail}",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteUser(@PathVariable( "userEmail" ) String userEmail) {

        try {
            atmanUserService.deleteUser(userEmail);
            return ResponseEntity.ok().build();

        } catch (UserManagementException e) {
            return ResponseEntity.badRequest().build();
        }

    }

}
