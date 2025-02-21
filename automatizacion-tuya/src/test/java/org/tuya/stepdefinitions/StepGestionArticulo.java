package org.tuya.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.tuya.questions.ValidacionElementoNoExiste;
import org.tuya.questions.ValidacionTextos;
import org.tuya.task.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

import static org.hamcrest.Matchers.equalTo;

public class StepGestionArticulo {

    private Actor actor;

    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
        actor = theActorCalled("Claudia");
    }

    @Given("que el usuario inicia sesión exitosamente en SwagLabs")
    public void theUserHasSuccessfullyLoggedIntoSwagLabs() {
        actor.wasAbleTo(TaskAbrirWeb.enSwagLab());
        actor.attemptsTo(TaskLogin.login(), TaskClick.sobreObjeto("login"));
    }

    @When("el usuario selecciona el articulo {string}")
    public void theUserSelectsTheItem(String articulo) {
        actor.attemptsTo(TaskClick.sobreObjeto(articulo), TaskGuardarDatos.descripcionObjeto());
    }

    @When("el usuario agrega el artículo al carrito")
    public void theUserAddsTheItemToTheCart() {
        actor.attemptsTo(TaskClick.sobreObjeto("addcart"));
    }

    @When("el usuario ingresa al carrito de compras")
    public void theUserEntersTheShoppingCart() {
        actor.attemptsTo(TaskClick.sobreObjeto("cart"));
    }

    @When("el usuario elimina el artículo del carrito")
    public void userRemovesItemFromCart() {
        actor.attemptsTo(TaskClick.sobreObjeto("eliminar"));
    }

    @When("el usuario selecciona tres articulos")
    public void theUserSelectsThreeItems() {
        actor.attemptsTo(TaskAgregarVarios.items());
    }

    @When("inicia el checkout")
    public void startCheckout() {
        actor.attemptsTo(TaskClick.sobreObjeto("iniciarcheckout"));
    }

    @When("ingresa sus datos")
    public void enterYourDetails() {
        actor.attemptsTo(TaskIngresarDatos.delusuario(),
                TaskClick.sobreObjeto("continuar"));
    }

    @When("finaliza la compra")
    public void completeThePurchase() {
        actor.attemptsTo(TaskClick.sobreObjeto("finalizar"));
    }

    @Then("el usuario no debería ver nada en el carrito")
    public void theUserShouldNotSeeAnythingInTheCart() {
        actor.should(seeThat(ValidacionElementoNoExiste.enPantalla(),equalTo(false)));
    }

    @Then("el usuario debería ver la descripción del artículo en el carrito")
    public void theUserShouldSeeTheItmDescriptionInTheCart() {
        String descripcion = Serenity.sessionVariableCalled("descripcion");
        actor.should(seeThat(ValidacionTextos.sobreText("inventory_item_desc"),
                equalTo(descripcion)));
    }

    @Then("el usuario debería ver el precio en el carrito")
    public void theUserShouldSeeThePriceInTheCar() {
        String precio = Serenity.sessionVariableCalled("precio");
        actor.should(seeThat(ValidacionTextos.sobreText("inventory_item_price"),
                equalTo(precio)));
    }

    @Then("debería ver un mensaje de compra finalizada")
    public void youShouldSeePurchaseCompletedMessage() {
        actor.should(seeThat(ValidacionTextos.sobreText(""),equalTo("THANK YOU FOR YOUR ORDER")));
    }

}
