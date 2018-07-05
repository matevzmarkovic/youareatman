package net.youareatman.rest.services;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.GenericYouAreAtmanException;
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

import static net.youareatman.helpers.YouAreAtmanHelpers.hashPassword;

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

    public AtmanUser listUser(String userEmail) throws GenericYouAreAtmanException {
        AtmanUser userEntry = atmanUserRepository.findById(userEmail).orElseThrow(() -> new UserManagementException("Error while reading user " + userEmail + "from database", ErrorTypesEnum.InvalidUserIdError));
        return userEntry;
    }

    public AtmanUser changePassword(String userEmail, ChangePasswordForm changePasswordForm) throws GenericYouAreAtmanException {
        AtmanUser userEntry = atmanUserRepository.findById(userEmail).orElseThrow(() -> new UserManagementException("Error while reading user " + userEmail + "from database", ErrorTypesEnum.InvalidUserIdError));
        userEntry.setPassHash(hashPassword(changePasswordForm.getPassword()));
        atmanUserRepository.save(userEntry);

        return userEntry;
    }

    public AtmanUser changeUserJoinDate(String userEmail, ChangeDateForm changeDateForm) throws GenericYouAreAtmanException{
        AtmanUser userEntry = atmanUserRepository.findById(userEmail).orElseThrow(() -> new UserManagementException("Error while reading user " + userEmail + "from database", ErrorTypesEnum.InvalidUserIdError));
        userEntry.setJoinDate(changeDateForm.getJoinDate());
        atmanUserRepository.save(userEntry);

        return userEntry;
    }

    //This method is for inside use only
    private AtmanUser createUser(AtmanUser user){
        atmanUserRepository.save(user);
        return user;
    }

    public AtmanUser createUser(String userEmail, String passHash){
        AtmanUser user = new AtmanUser(userEmail,passHash);
        atmanUserRepository.save(user);
        return user;
    }

    public boolean deleteUser(String userEmail) throws GenericYouAreAtmanException{
        if (atmanUserRepository.existsById(userEmail)) {
            atmanUserRepository.deleteById(userEmail);
            return true;
        }
        return false;
    }

}
