package com.obvious.controller;

import com.obvious.App;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(App.class)
public class TestLoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before
    public void enableApp() {
        App.main(new String[]{});
    }

    @Test
    public void login() {
        Response response = given().param("username", "meijie")
                .param("passwd", "123456")
                .when()
                .get("/login");
        logger.info("response: " + response.jsonPath().get().toString());
    }

}
