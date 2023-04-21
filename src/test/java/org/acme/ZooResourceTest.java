package org.acme;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.acme.dtos.AnimalsDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ZooResourceTest {

  @Test
  public void getAnimals_ShouldReturnAnimalsDtoWithMelaniDogsAndRats_WhenGivenMelaniAsOwner() {
    Response response = given().when().get("/zoo/animals/Melani").then().extract().response();

    Assertions.assertEquals(200, response.statusCode());

    ObjectMapper mapper = new ObjectMapper();
    AnimalsDto responseBody = mapper.convertValue(response.jsonPath().get(), AnimalsDto.class);

    Assertions.assertEquals(1, responseBody.getDogs().size());
    Assertions.assertEquals(1, responseBody.getRats().size());
    Assertions.assertEquals(0, responseBody.getCats().size());
    Assertions.assertEquals(0, responseBody.getDolphins().size());
  }
}
