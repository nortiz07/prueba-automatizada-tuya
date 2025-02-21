package org.tuya.stepdefinitions;

import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class ApiStepDefinitions {
    private static final String BASE_URL = System.getenv("URL_API");
    private final Actor usuario = Actor.named("Usuario");

    @Given("que el usuario quiere llamar el api")
    public void thatTheUserWantsToCallTheApi() {
        usuario.can(CallAnApi.at(BASE_URL));
    }

    @When("envía la solicitud con título {string}")
    public void sendRequestWithTitle(String titulo) {
        usuario.attemptsTo(
                Post.to("/posts")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body("{\"title\": \"" + titulo + "\", \"body\": \"Contenido\", \"userId\": 1}"))
        );
    }

    @When("cuando consulta el usuario {string}")
    public void whenTheUserQueries(String id) {
        usuario.attemptsTo(
                Get.resource("/posts/"+id)
        );
    }

    @Then("el código de respuesta debe ser {int}")
    public void validateResponseCode(int codigo) {
        usuario.should(
                ResponseConsequence.seeThatResponse("El código de respuesta es correcto",
                        response -> response.statusCode(codigo))
        );
    }

    @Then("la respuesta debe contener el campo title con el valor {string}")
    public void validFieldTitle(String tituloEsperado) {
        usuario.should(
                ResponseConsequence.seeThatResponse("El campo 'title' es correcto",
                        response -> response.body("title", equalTo(tituloEsperado)))
        );
    }

    @Then("la respuesta debe contener el campo id con el valor {string}")
    public void theResponseMustContainTheIdFieldWithTheValue(String id) {
        int idEsperado = Integer.parseInt(id);
        usuario.should(
                ResponseConsequence.seeThatResponse("El campo id es correcto",
                        response -> response.body("id",equalTo(idEsperado)))
        );
    }
}

