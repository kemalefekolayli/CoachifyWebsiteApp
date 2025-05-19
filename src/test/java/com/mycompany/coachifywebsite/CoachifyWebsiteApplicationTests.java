package com.mycompany.coachifywebsite;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "spring.data.mongodb.uri=mongodb://localhost:27017/coachify-test",
        "jwt.secret=testing-secret-key-for-jwt-token-validation-testing-only"
})
class CoachifyWebsiteApplicationTests {

    @Test
    void contextLoads() {
    }
}