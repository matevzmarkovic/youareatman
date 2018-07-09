package net.youareatman;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.IncidentManagementException;
import net.youareatman.exceptions.UserManagementException;
import net.youareatman.helpers.YouAreAtmanHelpers;
import net.youareatman.model.AtmanUser;
import net.youareatman.model.IncidentEntry;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HelpersTest {

    private static String EMAIL_INVALID_EMPTY = "";
    private static String EMAIL_INVALID_REGEX = "marka";
    private static String EMAIL_CORRECT = "marka@arnes.si";

    private static String PASSWORD_HASH_EMPTY = "";
    private static String PASSWORD_HASH_TOO_SHORT = "passwordWaaayToooShort";
    private static String PASSWORD_HASH_CORRECT = "3$hS&\\D#rcv9VHtacN7*<Mj{qPLA@?S6zdB^^4RZ\"XM)u@BThVmj#;t+7fYj";

    private static String PASSWORD_EMPTY = "";

    private static String INCIDENT_ID_EMPTY = "";
    private static String INCIDENT_ID_CORRECT = "id0";

    @Test
    public void testValidateUserEmail_isEmpty() {
        try {
            YouAreAtmanHelpers.validateUserEmail(EMAIL_INVALID_EMPTY);
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
            YouAreAtmanHelpers.validateUserEmail(EMAIL_INVALID_REGEX);
        }
        catch(UserManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.InvalidUserEmailError);
        }
        try {
            YouAreAtmanHelpers.validateUserEmail_Incident(EMAIL_INVALID_REGEX);
        }
        catch(IncidentManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.InvalidUserEmailError);
        }
    }
    //No exception should be thrown. If it is, something is wrong with email validation.
    @Test(expected = Test.None.class)
    public void testValidateUserEmail_correctEmail() throws UserManagementException {
        YouAreAtmanHelpers.validateUserEmail(EMAIL_CORRECT);
    }

    @Test
    public void testValidatePasswordHash_isEmpty() {
        try {
            YouAreAtmanHelpers.validatePasswordHash(PASSWORD_HASH_EMPTY);
        }
        catch(UserManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.EmptyPasswordHashError);
        }
    }
    @Test
    public void testValidatePasswordHash_isInvalid() {
        try {
            YouAreAtmanHelpers.validatePasswordHash(PASSWORD_HASH_TOO_SHORT);
        }
        catch(UserManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.MalformedPasswordHashError);
        }
    }
    //No exception should be thrown. If it is, something is wrong with password hash validation.
    @Test(expected = Test.None.class)
    public void testValidatePasswordHash_correctPassword() throws UserManagementException {
        YouAreAtmanHelpers.validatePasswordHash(PASSWORD_HASH_CORRECT);
    }

    @Test
    public void testValidatePassword_isEmpty() {
        try {
            YouAreAtmanHelpers.validatePasswordRaw(PASSWORD_EMPTY);
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
            YouAreAtmanHelpers.validateIncidentId(INCIDENT_ID_EMPTY);
        }
        catch(IncidentManagementException e) {
            assertEquals(e.getErrorType(),ErrorTypesEnum.EmptyIncidentIdError);
        }
    }

    @Test(expected = IncidentManagementException.class)
    public void testValidateIncidentEntry_invalid() throws IncidentManagementException {
        IncidentEntry entry = new IncidentEntry(INCIDENT_ID_EMPTY,null, new AtmanUser(EMAIL_INVALID_EMPTY, PASSWORD_HASH_TOO_SHORT),"","","");
        YouAreAtmanHelpers.validateIncidentEntry(entry);
    }
    //No exception should be thrown. If it is, something is wrong with incident entry validation.
    @Test(expected = Test.None.class)
    public void testValidateIncidentEntry_correct() throws IncidentManagementException {
        Date incidentDate = new Date();
        IncidentEntry entry = new IncidentEntry(INCIDENT_ID_CORRECT,incidentDate, new AtmanUser(EMAIL_CORRECT, PASSWORD_HASH_CORRECT),"","","");
        YouAreAtmanHelpers.validateIncidentEntry(entry);
    }

}
