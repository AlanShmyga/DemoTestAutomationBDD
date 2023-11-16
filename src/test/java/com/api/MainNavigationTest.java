package com.api;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class MainNavigationTest {

    public static final String BASE_URL = "http://localhost:8080/api";
    private static final String URL = BASE_URL + "/points";

    @Test
    public void shouldReturnValidResponse() {
        given()
            .baseUri(BASE_URL)
        .when()
            .get(URL)
        .then()
            .statusCode(200)
        .assertThat().body("_embedded.points.title", hasItem("Vai Beach"));
    }
}
