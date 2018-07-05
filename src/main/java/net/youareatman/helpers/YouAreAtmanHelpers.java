package net.youareatman.helpers;

import net.youareatman.exceptions.UserManagementException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.regex.Pattern;

import static net.youareatman.enums.ErrorTypesEnum.*;

public class YouAreAtmanHelpers {

    static final String emailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    static final Pattern emailPattern = Pattern.compile(emailRegex);
    static final int HashLength = 60;

    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String hashPassword(String password){
        return passwordEncoder.encode(password);
    }

    public static void validateUserEmail(String email) throws UserManagementException {
        if (email == null || email.length() == 0) {
            throw new UserManagementException("Empty email was provided.",EmptyUserEmailError);
        }

        if (!emailPattern.matcher(email).matches()) {
            throw new UserManagementException("Provided user email is invalid.",InvalidUserEmailError);
        }
    }

    public static void validatePasswordHash(String passwordHash) throws UserManagementException {
        if (passwordHash == null) {
            throw new UserManagementException("Empty password hash was provided.",EmptyPasswordHashError);
        } else if (passwordHash.length() != HashLength) {
            throw new UserManagementException("Invalid password hash was provided.",InvalidPasswordHashError);
        }
    }

    public static void validatePasswordRaw(String passwordRaw) throws UserManagementException {
        if (passwordRaw == null) {
            throw new UserManagementException("Empty password was provided.",EmptyPasswordError);
        }
    }

    public static void validateDate(Date date) throws UserManagementException {
        if (date == null) {
            throw new UserManagementException("Empty date was provided.",InvalidDate);
        }
    }

}
