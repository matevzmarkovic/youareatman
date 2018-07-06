package net.youareatman.rest.controllers;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.UserManagementException;
import net.youareatman.model.*;
import net.youareatman.model.forms.*;
import net.youareatman.rest.services.AtmanUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class AtmanUserController {

    @Autowired
    private AtmanUserService atmanUserService;

    private static Logger logger = LogManager.getLogger(AtmanUserController.class);

    //******************************************************************************************************************
    //                                              User management
    //******************************************************************************************************************

    @RequestMapping(value = "/atmanusers",method=GET)
    @ResponseBody
    public ResponseEntity<List<AtmanUser>> listUsers() {
        List<AtmanUser> users = atmanUserService.listUsers();
        return new ResponseEntity(users,HttpStatus.OK);
    }

    @RequestMapping(value = "/atmanusers/{userEmail}",method=GET)
    @ResponseBody
    public ResponseEntity<AtmanUser> listUser(@PathVariable( "userEmail" ) String userEmail) {
        try {
            AtmanUser user = atmanUserService.listUser(userEmail);
            return new ResponseEntity(user,HttpStatus.OK);
        } catch (UserManagementException e) {
            return processUserManagementException(e);
        }

    }

    @RequestMapping(value = "/atmanusers/{userEmail}/password",method=PUT)
    @ResponseBody
    public ResponseEntity changeUserPassword(@PathVariable( "userEmail" ) String userEmail,@RequestBody ChangePasswordForm changePasswordForm) {

        try {
            AtmanUser user = atmanUserService.changePassword(userEmail, changePasswordForm);
            return new ResponseEntity(user,HttpStatus.OK);
        } catch (UserManagementException e) {
            return processUserManagementException(e);
        }
    }

    @RequestMapping(value = "/atmanusers/{userEmail}/date",method=PUT)
    @ResponseBody
    public ResponseEntity changeUserJoinDate(@PathVariable( "userEmail" ) String userEmail,@RequestBody ChangeDateForm changeDateForm) {

        try{
            AtmanUser user = atmanUserService.changeUserJoinDate(userEmail, changeDateForm);
            return new ResponseEntity(user,HttpStatus.OK);
        }
        catch(UserManagementException e){
            return processUserManagementException(e);
        }
    }

    @RequestMapping(value = "/atmanusers/{userEmail}",method=POST)
    @ResponseBody
    public ResponseEntity createUser(@PathVariable( "userEmail" ) String userEmail, @RequestBody String password) {
        try {
            AtmanUser user = atmanUserService.createUser(userEmail, password);
            return new ResponseEntity(user,HttpStatus.CREATED);
        } catch (UserManagementException e) {
            return processUserManagementException(e);
        }
    }

    @RequestMapping(value = "/atmanusers/{userEmail}",method=DELETE)
    @ResponseBody
    public ResponseEntity deleteUser(@PathVariable( "userEmail" ) String userEmail) {

        try {
            atmanUserService.deleteUser(userEmail);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (UserManagementException e) {
            return processUserManagementException(e);
        }
    }

    /**
     * Generate response in accordance with the nature of exception that occurred.
     * @param e the exception that occurred
     * @return Response entity with the correct HttpStatus code
     */
    private ResponseEntity processUserManagementException(UserManagementException e) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("error_message",e.getMessage());

        ErrorTypesEnum errorType = e.getErrorType();
        if (errorType.equals(ErrorTypesEnum.UserNotFoundError)){
            return new ResponseEntity(httpHeaders,HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(httpHeaders,HttpStatus.BAD_REQUEST);
        }
    }

}
