package net.youareatman.rest.services;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.UserManagementException;
import net.youareatman.model.AtmanUser;
import net.youareatman.model.forms.ChangeDateForm;
import net.youareatman.model.forms.ChangePasswordForm;
import net.youareatman.rest.repositories.AtmanUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static net.youareatman.enums.ErrorTypesEnum.UserExists;
import static net.youareatman.helpers.YouAreAtmanHelpers.*;
import static net.youareatman.helpers.YouAreAtmanHelpers.validatePasswordHash;

@Service
public class AtmanUserService {

    @Autowired
    private AtmanUserRepository atmanUserRepository;

    private static Logger logger = LogManager.getLogger(AtmanUserService.class);

    public AtmanUserService(AtmanUserRepository atmanUserRepository) {
        this.atmanUserRepository = atmanUserRepository;
    }

    public List<AtmanUser> listUsers(){
        List<AtmanUser> users = new ArrayList<AtmanUser>();
        atmanUserRepository.findAll().forEach(users::add);
        return users;
    }

    public AtmanUser listUser(String userEmail) throws UserManagementException {
        validateUserEmail(userEmail);

        AtmanUser userEntry = atmanUserRepository.findById(userEmail).orElseThrow(() -> new UserManagementException("Error while reading user " + userEmail + "from database", ErrorTypesEnum.UserNotFoundError));
        return userEntry;
    }

    public AtmanUser changePassword(String userEmail, ChangePasswordForm changePasswordForm) throws UserManagementException {
        validateUserEmail(userEmail);
        validatePasswordRaw(changePasswordForm.getPassword());

        AtmanUser userEntry = atmanUserRepository.findById(userEmail).orElseThrow(() -> new UserManagementException("Error while reading user " + userEmail + "from database", ErrorTypesEnum.UserNotFoundError));
        userEntry.setPassHash(hashPassword(changePasswordForm.getPassword()));
        atmanUserRepository.save(userEntry);

        return userEntry;
    }

    public AtmanUser changeUserJoinDate(String userEmail, ChangeDateForm changeDateForm) throws UserManagementException{
        validateUserEmail(userEmail);
        validateDate(changeDateForm.getJoinDate());

        AtmanUser userEntry = atmanUserRepository.findById(userEmail).orElseThrow(() -> new UserManagementException("Error while reading user " + userEmail + "from database", ErrorTypesEnum.UserNotFoundError));
        userEntry.setJoinDate(changeDateForm.getJoinDate());
        atmanUserRepository.save(userEntry);

        return userEntry;
    }

    //This method is for inside use only, no need for validation
    private AtmanUser createUser(AtmanUser user){
        atmanUserRepository.save(user);
        return user;
    }

    public AtmanUser createUser(String userEmail, String password) throws UserManagementException{

        validateUserEmail(userEmail);
        validatePasswordRaw(password);
        String passHash = hashPassword(password);
        validatePasswordHash(passHash);

        if (atmanUserRepository.existsById(userEmail)) {
            throw new UserManagementException("This user already exists",UserExists);
        }

        AtmanUser user = new AtmanUser(userEmail,passHash);
        atmanUserRepository.save(user);
        return user;


    }

    public void deleteUser(String userEmail) throws UserManagementException{
        validateUserEmail(userEmail);

        if (atmanUserRepository.existsById(userEmail)) {
            atmanUserRepository.deleteById(userEmail);
        }
    }

}
