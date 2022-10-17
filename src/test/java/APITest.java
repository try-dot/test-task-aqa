
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

class APITest {

    @Test
    void compareJSONSchema() {
        RestAssured.baseURI = "https://swapi.dev";
        given()
                .when()
                .get("/api/starships/9/")
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/java/resources/WEHatfgD.json")));
    }
}
