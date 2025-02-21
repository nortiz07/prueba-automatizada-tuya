package org.tuya.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.tuya.ui.PaginaInicio.INPUT_LOGIN;

public class TaskLogin implements Task {

    private final String usser = System.getenv("USERNAME");
    private final String password = System.getenv("PASS");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(INPUT_LOGIN.of("Username"), isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(usser).into(INPUT_LOGIN.of("Username")));

        actor.attemptsTo(WaitUntil.the(INPUT_LOGIN.of("Password"), isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(password).into(INPUT_LOGIN.of("Password")));
    }

    public static TaskLogin login() {
        return Tasks.instrumented(TaskLogin.class);
    }
}
