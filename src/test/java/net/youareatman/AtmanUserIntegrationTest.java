package net.youareatman;

import net.youareatman.helpers.YouAreAtmanHelpers;
import net.youareatman.model.AtmanUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AtmanUserIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void hashTest() {
        assertEquals(YouAreAtmanHelpers.hashPassword("testPassword!!!"),"$2a$10$3zvoe/h3qjUrBG5Gb1dv0uzVUIz2JMhltBVRKtjVaW9DnpA3V941e");

    }

    @Test
    public void createAtmanUser() {

    }

}
