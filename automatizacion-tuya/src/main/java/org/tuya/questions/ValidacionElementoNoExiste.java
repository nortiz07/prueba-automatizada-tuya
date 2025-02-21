package org.tuya.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static org.tuya.ui.PaginaCarrito.DESCRIP_PRECIO_CARRITO;

public class ValidacionElementoNoExiste implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return DESCRIP_PRECIO_CARRITO.of("inventory_item_desc").resolveFor(actor).isPresent();
    }

    public static ValidacionElementoNoExiste enPantalla(){
        return new ValidacionElementoNoExiste();
    }
}
