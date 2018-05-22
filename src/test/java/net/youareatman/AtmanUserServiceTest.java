package net.youareatman;

import net.youareatman.rest.repositories.AtmanUserRepository;
import net.youareatman.rest.services.AtmanUserService;
import org.junit.Before;
import org.mockito.Mockito;

public class AtmanUserServiceTest {

    private AtmanUserService atmanUserService;
    private AtmanUserRepository atmanUserRepositoryMock;

    @Before
    public void setUp() {
        atmanUserRepositoryMock = Mockito.mock(AtmanUserRepository.class);
        atmanUserService = new AtmanUserService(atmanUserRepositoryMock);
    }

}
