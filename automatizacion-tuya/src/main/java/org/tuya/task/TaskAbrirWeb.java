package org.tuya.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import org.tuya.ui.PaginaInicio;

public class TaskAbrirWeb implements Task {

    private PaginaInicio paginaInicio;

    public static TaskAbrirWeb enSwagLab(){
        return Tasks.instrumented(TaskAbrirWeb.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(paginaInicio));
    }
}
