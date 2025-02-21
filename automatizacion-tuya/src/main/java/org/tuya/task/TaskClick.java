package org.tuya.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.tuya.ui.PaginaArticulo.*;
import static org.tuya.ui.PaginaCarrito.CHECKOUT;
import static org.tuya.ui.PaginaCarrito.ELIMINAR_PRODUCTO;
import static org.tuya.ui.PaginaInicio.BTN_LOGIN;

public class TaskClick implements Task {

    private final String clickEsperado;
    private final Map<String, Target> clickEsperadoMap;

    public TaskClick(String clickEsperado) {
        this.clickEsperado = clickEsperado;
        this.clickEsperadoMap = inicializarMap();
    }

    private Map<String, Target> inicializarMap(){
        Map<String, Target> clickEsperadoMap = new HashMap<>();

        clickEsperadoMap.put("Sauce Labs Onesie",SELECCION_ARTICULO.of(clickEsperado));
        clickEsperadoMap.put("login",BTN_LOGIN);
        clickEsperadoMap.put("addcart",BTN_ADD_CART);
        clickEsperadoMap.put("cart",BTN_CARRITO);
        clickEsperadoMap.put("eliminar",ELIMINAR_PRODUCTO);
        clickEsperadoMap.put("agregaritems",ELIMINAR_PRODUCTO);
        clickEsperadoMap.put("iniciarcheckout",CHECKOUT);

        return clickEsperadoMap;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        Target clickEsperadoTarget = clickEsperadoMap.get(clickEsperado);

        if (clickEsperadoTarget == null) {
            throw new IllegalArgumentException("No se ha encontrado el botón: " + clickEsperado);
        }

        // Realiza el scroll y espera a que sea visible antes de hacer click
        actor.attemptsTo(
                Scroll.to(clickEsperadoTarget),
                WaitUntil.the(clickEsperadoTarget, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(clickEsperadoTarget)
        );

    }

    public static TaskClick sobreObjeto(String clickEsperado) {
        return Tasks.instrumented(TaskClick.class, clickEsperado);
    }
}
