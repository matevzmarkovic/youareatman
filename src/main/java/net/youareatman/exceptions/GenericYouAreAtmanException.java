package net.youareatman.exceptions;

import net.youareatman.enums.ErrorTypesEnum;

public class GenericYouAreAtmanException extends Exception {

    private ErrorTypesEnum errorType;

    public GenericYouAreAtmanException() {
    }

    public GenericYouAreAtmanException(String message, ErrorTypesEnum errorType) {
        super(message);
        this.errorType = errorType;
    }

    public ErrorTypesEnum getErrorType() {
        return errorType;
    }

    @Override
    public String toString() {
        return "GenericYouAreAtmanException{" +
                "errorType=" + errorType +
                '}';
    }
}
