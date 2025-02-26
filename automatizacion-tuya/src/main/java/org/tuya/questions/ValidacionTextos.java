package org.tuya.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.tuya.ui.PaginaCarrito.DESCRIP_PRECIO_CARRITO;
import static org.tuya.ui.PaginaCarrito.TITULO_FINALIZACION;

public class ValidacionTextos implements Question<String> {

    String textEsperado;

    public ValidacionTextos(String textEsperado) {
        this.textEsperado = textEsperado;
    }


    @Override
    public String answeredBy(Actor actor) {
        if (textEsperado.equals("inventory_item_desc") || textEsperado.equals("inventory_item_price") ) {
            actor.attemptsTo(WaitUntil.the(DESCRIP_PRECIO_CARRITO.of(textEsperado), isVisible()).forNoMoreThan(10).seconds());

            return Text.of(DESCRIP_PRECIO_CARRITO.of(textEsperado)).answeredBy(actor);
        }
        actor.attemptsTo(WaitUntil.the(TITULO_FINALIZACION, isVisible()).forNoMoreThan(10).seconds());
        return Text.of(TITULO_FINALIZACION).answeredBy(actor);
    }

    public static ValidacionTextos sobreText(String textEsperado) {
        return new ValidacionTextos(textEsperado);
    }
}
