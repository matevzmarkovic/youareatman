package net.youareatman.exceptions;

import net.youareatman.enums.ErrorTypesEnum;

public class IncidentManagementException extends GenericYouAreAtmanException {

    public IncidentManagementException() {
    }

    public IncidentManagementException(String message, ErrorTypesEnum errorType) {
        super(message, errorType);
    }


    @Override
    public String toString() {
        return "IncidentManagementException{" +
                "message=" + getMessage() +
                "errorType=" + getErrorType() +
                '}';
    }
}
