package org.tuya.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.tuya.ui.PaginaArticulo.AGREGAR_CARRITO_ITEMS;

public class TaskAgregarVarios implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i=1;i<=3;i++){
            actor.attemptsTo(
                    Scroll.to(AGREGAR_CARRITO_ITEMS.of(String.valueOf(i))),
                    WaitUntil.the(AGREGAR_CARRITO_ITEMS.of(String.valueOf(i)), isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(AGREGAR_CARRITO_ITEMS.of(String.valueOf(i)))
            );
        }
    }

    public static TaskAgregarVarios items() {
        return Tasks.instrumented(TaskAgregarVarios.class);
    }
}
