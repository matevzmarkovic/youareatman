package net.youareatman.enums;

public enum ErrorTypesEnum {

    UnknownError(1,"Unknown error."),
    CRUDError(2,"Error while performing a CRUD operation on the database."),
    UserNotFoundError(3,"Unable to find user with this id (email) in the database."),
    IncidentNotFoundError(4,"Unable to find incident with this id in the database."),
    EmptyUserEmailError(5,"Provided user email was empty."),
    EmptyPasswordHashError(6,"Provided password hash was empty."),
    InvalidUserEmailError(7,"Provided user email is invalid."),
    InvalidPasswordHashError(8,"Provided password hash is invalid."),
    InvalidDate(9,"Provided date is invalid."),
    EmptyPasswordError(10,"Empty raw password was provided."),
    EmptyIncidentIdError(11,"Provided incidentId was empty.")
    ;

    private final int code;
    private final String description;

    ErrorTypesEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ErrorTypesEnum{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
