package net.youareatman;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.GenericYouAreAtmanException;
import net.youareatman.exceptions.UserManagementException;
import net.youareatman.model.AtmanUser;
import net.youareatman.rest.repositories.AtmanUserRepository;
import net.youareatman.rest.services.AtmanUserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class AtmanUserServiceTest {

    private AtmanUserService atmanUserServiceMock;
    private AtmanUserRepository atmanUserRepositoryMock;

    @Before
    public void setUp() {
        atmanUserRepositoryMock = Mockito.mock(AtmanUserRepository.class);
        atmanUserServiceMock = new AtmanUserService(atmanUserRepositoryMock);
    }

    @Test
    public void createAtmanUserSuccessfully() throws Exception {
        when(atmanUserRepositoryMock.findById(eq("test@arnes.si"))).thenReturn(Optional.empty());
        doAnswer(returnsFirstArg()).when(atmanUserRepositoryMock).save(any(AtmanUser.class));

        AtmanUser atmanUser = atmanUserServiceMock.createUser("test@arnes.si", "AAAA");
        assertEquals("test@arnes.si", atmanUser.getUserEmail());
        assertNotNull(atmanUser.getPassHash());

    }

    @Test(expected = UserManagementException.class)
    public void createAtmanUserWithEmptyEmail() throws Exception {
        atmanUserServiceMock.createUser("","HashPass");
    }

}
