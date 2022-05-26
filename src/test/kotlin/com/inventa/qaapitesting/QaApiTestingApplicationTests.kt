package com.inventa.qaapitesting

import org.springframework.boot.test.context.SpringBootTest
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class ExampleTestApiApplicationTests  {

    //Post

    @Test
    public void create()
    {
        given()
                .header("Content-Type", "application/json")
                .body("{\r\n"
                        + "	\"id\":\"1\",\r\n"
                        + "	\"name\":\"Produto1\",\r\n"
                        + "	\"sku\":\"1234\",\r\n"
                        + "	\"description\":\"Produto criado na entrevista\"\r\n"
                        + "}")
                .when ()
                .post("http://localhost:3000/products")
                .then()
                .statusCode(200)
                .body("", hasKey("id"))
                .body("id", instanceOf(Long.Class))
                .body("", hasKey("name"))
                .body("name", instanceOf(String.Class))
                .body("", hasKey("sku"))
                .body("sku", instanceOf(Long.Class))
                .body("", hasKey("description"))
                .body("description", instanceOf(String.Class))
    }

    @Test
    public void get(){
        //Get

        given()
                .header("Content-Type", "application/json")
                .when()
                .get("http://localhost:3000/products?id=1")
                .then()
                .statusCode(200);

    }


}