package net.youareatman.rest.services;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.GenericYouAreAtmanException;
import net.youareatman.model.User;
import net.youareatman.model.forms.ChangeDateForm;
import net.youareatman.model.forms.ChangePasswordForm;
import net.youareatman.rest.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.endpoint.GenericMessageEndpointFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = LogManager.getLogger(UserService.class);

    public List<User> listUsers(){
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    public User listUser(String userEmail) throws GenericYouAreAtmanException {
        User userEntry = userRepository.findById(userEmail).orElseThrow(() -> new GenericYouAreAtmanException("Error while reading user from database", ErrorTypesEnum.CRUDError));
        return userEntry;
    }

    public User changePassword(String userEmail, ChangePasswordForm changePasswordForm) throws GenericYouAreAtmanException {
        User userEntry = userRepository.findById(userEmail).orElseThrow(() -> new GenericYouAreAtmanException("Error while reading user from database", ErrorTypesEnum.CRUDError));
        userEntry.setPasswordHash(changePasswordForm.getPassword());
        userRepository.save(userEntry);

        return userEntry;
    }

    public User changeUserJoinDate(String userEmail, ChangeDateForm changeDateForm) throws GenericYouAreAtmanException{
        User userEntry = userRepository.findById(userEmail).orElseThrow(() -> new GenericYouAreAtmanException("Error while reading user from database", ErrorTypesEnum.CRUDError));
        userEntry.setJoinDate(changeDateForm.getJoinDate());
        userRepository.save(userEntry);

        return userEntry;
    }

    public User createUser(User user){
        userRepository.save(user);
        return user;
    }

    public User deleteUser(String userEmail) throws GenericYouAreAtmanException{
        User user = userRepository.findById(userEmail).orElseThrow(() -> new GenericYouAreAtmanException("Error while reading user from database", ErrorTypesEnum.CRUDError));
        userRepository.deleteById(userEmail);
        return user;
    }

}
