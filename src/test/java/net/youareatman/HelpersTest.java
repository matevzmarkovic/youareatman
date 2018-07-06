package net.youareatman;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.IncidentManagementException;
import net.youareatman.exceptions.UserManagementException;
import net.youareatman.helpers.YouAreAtmanHelpers;
import net.youareatman.model.AtmanUser;
import net.youareatman.model.IncidentEntry;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelpersTest {

    @Test
    public void testValidateUserEmail_isEmpty() {
        try {
            YouAreAtmanHelpers.validateUserEmail("");
        }
        catch(UserManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.EmptyUserEmailError);
        }
        try {
            YouAreAtmanHelpers.validateUserEmail_Incident("");
        }
        catch(IncidentManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.EmptyUserEmailError);
        }
    }

    @Test
    public void testValidateUserEmail_invalidRegex() {
        try {
            YouAreAtmanHelpers.validateUserEmail("abc");
        }
        catch(UserManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.InvalidUserEmailError);
        }
        try {
            YouAreAtmanHelpers.validateUserEmail_Incident("abc");
        }
        catch(IncidentManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.InvalidUserEmailError);
        }
    }

    @Test
    public void testValidatePasswordHash_isEmpty() {
        try {
            YouAreAtmanHelpers.validatePasswordHash("");
        }
        catch(UserManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.EmptyPasswordHashError);
        }
    }

    @Test
    public void testValidatePasswordHash_isInvalid() {
        try {
            YouAreAtmanHelpers.validatePasswordHash("passwordWaaayToooShort");
        }
        catch(UserManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.MalformedPasswordHashError);
        }
    }

    @Test
    public void testValidatePassword_isEmpty() {
        try {
            YouAreAtmanHelpers.validatePasswordRaw("");
        }
        catch(UserManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.EmptyPasswordError);
        }
    }

    @Test
    public void testValidateDate_isNull() {
        try {
            YouAreAtmanHelpers.validateDate(null);
        }
        catch(UserManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.EmptyDate);
        }

        try {
            YouAreAtmanHelpers.validateDate_Incident(null);
        }
        catch(IncidentManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.EmptyDate);
        }
    }

    @Test
    public void testValidateIncidentId_isEmpty() {
        try {
            YouAreAtmanHelpers.validateIncidentId("");
        }
        catch(IncidentManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.EmptyIncidentIdError);
        }
    }

    @Test
    public void testValidateIncidentEntry() {
        IncidentEntry entry = new IncidentEntry("id0",null, new AtmanUser("whateverUserNotEmail","passHash"),"","","");

        try {
            YouAreAtmanHelpers.validateIncidentEntry(entry);
        }
        catch(IncidentManagementException e) {
            return;
        }
    }

}
