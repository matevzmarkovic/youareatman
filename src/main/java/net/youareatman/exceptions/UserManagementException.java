package net.youareatman.exceptions;

import net.youareatman.enums.ErrorTypesEnum;

public class UserManagementException extends GenericYouAreAtmanException {

    public UserManagementException() {
    }

    public UserManagementException(String message, ErrorTypesEnum errorType) {
        super(message, errorType);
    }

    @Override
    public String toString() {
        return "UserManagementException{" +
                "message=" + getMessage() +
                "errorType=" + getErrorType() +
                '}';
    }
}
