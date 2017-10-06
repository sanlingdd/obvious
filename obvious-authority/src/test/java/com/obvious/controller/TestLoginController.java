package com.obvious.controller;

import com.obvious.App;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(App.class)
public class TestLoginController {

    @Before
    public void enableApp() {
        App.main(new String[]{});
    }

    @Test
    public void login() {
        given().param("username", "meijie")
                .param("passwd", "123456")
                .when()
                .post("/login");
    }

}
