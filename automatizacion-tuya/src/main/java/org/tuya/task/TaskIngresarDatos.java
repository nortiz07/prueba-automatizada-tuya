package org.tuya.task;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.jetbrains.annotations.NotNull;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.tuya.ui.PaginaCarrito.INPUT_DATOS;
import static org.tuya.ui.PaginaInicio.INPUT_LOGIN;

public class TaskIngresarDatos implements Task {
    Faker faker = new Faker();

    @Override
    public <T extends Actor> void performAs(T actor) {
        ingresarcampo(actor, "First Name" );
        ingresarcampo(actor, "Last Name" );
        ingresarcampo(actor, "Zip/Postal Code" );
    }

    private <T extends Actor> void ingresarcampo(@NotNull T actor, String campo) {

        String name = faker.name().fullName();

        actor.attemptsTo(WaitUntil.the(INPUT_DATOS.of(campo), isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(name).into(INPUT_LOGIN.of(campo)));

    }

    public static TaskIngresarDatos delusuario() {
        return Tasks.instrumented(TaskIngresarDatos.class);
    }
}
