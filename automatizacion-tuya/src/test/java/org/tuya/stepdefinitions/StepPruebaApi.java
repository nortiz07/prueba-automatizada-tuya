package org.tuya.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class StepPruebaApi {
    private Response response;

    @Given("que quiero crear un nuevo post")
    public void queQuieroCrearUnNuevoPost() {
        // Configurar el Actor con la habilidad CallAnApi
        Actor actor = Actor.named("Usuario API")
                .whoCan(CallAnApi.at("https://jsonplaceholder.typicode.com")); // URL base de la API
        theActorInTheSpotlight().attemptsTo(); // Asignar el actor al escenario
    }

    @When("envío una solicitud POST al endpoint {string} con los datos:")
    public void envioUnaSolicitudPOSTAlEndpointConLosDatos(String endpoint, io.cucumber.datatable.DataTable dataTable) {
        // Obtener los datos de la tabla
        Map<String, String> data = dataTable.asMaps().get(0);

        // Realizar la solicitud POST
        theActorInTheSpotlight().attemptsTo(
                Post.to(endpoint)
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(data)
                        )
        );
        response = SerenityRest.lastResponse();
    }

    @Then("el código de respuesta debe ser {int}")
    public void elCodigoDeRespuestaDebeSer(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("la respuesta debe contener el título {string}")
    public void laRespuestaDebeContenerElTitulo(String titulo) {
        response.then().body("title", equalTo(titulo));
    }

}
