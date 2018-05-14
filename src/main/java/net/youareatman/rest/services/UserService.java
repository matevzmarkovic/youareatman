package net.youareatman.rest.services;

import net.youareatman.model.User;
import net.youareatman.model.forms.ChangeDateForm;
import net.youareatman.model.forms.ChangePasswordForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static Logger logger = LogManager.getLogger(UserService.class);

    public List<User> listUsers(){
        return null;

    }

    public User listUser(String email) {
        return null;
    }

    public User changePassword(String userEmail, ChangePasswordForm changePasswordForm){
        return null;
    }

    public User changeUserJoinDate(String userEmail, ChangeDateForm changeDateForm){
        return null;
    }

    public User createUser(String userEmail, User user){
        return null;
    }

    public User deleteUser(String userEmail){
        return null;
    }

}
