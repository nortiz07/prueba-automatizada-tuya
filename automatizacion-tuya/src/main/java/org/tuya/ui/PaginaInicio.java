package org.tuya.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.saucedemo.com/v1/")
public class PaginaInicio extends PageObject {

    public static final Target INPUT_LOGIN = Target.the("Imput para ingresar usser y password")
            .locatedBy("//input[@placeholder='{0}']");

    public static final Target BTN_LOGIN = Target.the("Botón de login")
            .locatedBy("//input[@class='btn_action']");

}
