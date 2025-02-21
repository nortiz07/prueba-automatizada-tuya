package org.tuya.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaInicio extends PageObject {

    private static final String BASEURL = System.getenv("BASE_URL");

    public PaginaInicio(){
        super();
        this.setDefaultBaseUrl(BASEURL);
    }

    public static final Target INPUT_LOGIN = Target.the("Imput para ingresar usser y password")
            .locatedBy("//input[@placeholder='{0}']");

    public static final Target BTN_LOGIN = Target.the("Botón de login")
            .locatedBy("//input[@class='btn_action']");

}
