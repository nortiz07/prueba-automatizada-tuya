package org.tuya.task;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static org.tuya.ui.PaginaArticulo.CAMPO_DESCRIP_PRECIO;

@Slf4j
public class TaskGuardarDatos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        guardarDescripcion(actor);
        guardarPrecio(actor);
    }

    private <T extends Actor> void guardarDescripcion(T actor) {
        String descripcion = actor.asksFor(Text.of(CAMPO_DESCRIP_PRECIO.of("inventory_details_desc")));
        Serenity.setSessionVariable("descripcion").to(descripcion);
        log.info("Descripción guardada: {}", descripcion);
    }

    private <T extends Actor> void guardarPrecio(T actor) {
        String precioTexto = actor.asksFor(Text.of(CAMPO_DESCRIP_PRECIO.of("inventory_details_price")));
        String precioLimpio = precioTexto.replaceAll("\\$", "").trim();
        Serenity.setSessionVariable("precio").to(precioLimpio);
        log.info("Precio guardado: {}", precioLimpio);
    }

    public static TaskGuardarDatos descripcionObjeto() {
        return Tasks.instrumented(TaskGuardarDatos.class);
    }
}
