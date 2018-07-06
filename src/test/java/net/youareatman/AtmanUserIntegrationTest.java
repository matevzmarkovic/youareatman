package net.youareatman;

import net.youareatman.enums.ErrorTypesEnum;
import net.youareatman.exceptions.IncidentManagementException;
import net.youareatman.exceptions.UserManagementException;
import net.youareatman.helpers.YouAreAtmanHelpers;
import net.youareatman.model.AtmanUser;
import net.youareatman.model.IncidentEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AtmanUserIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void APItest() throws Exception {

        assertThat(restTemplate.getForObject("https://localhost:"+String.valueOf(port)+"/YouAreAtman/api/atmanusers",List.class).isEmpty() == false);
    }

}
