package org.tuya.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaCarrito extends PageObject{

    public static final Target DESCRIP_PRECIO_CARRITO = Target.the("Descripción artículo carrito")
            .locatedBy("//div[@class='{0}']");

    public static final Target ELIMINAR_PRODUCTO = Target.the("Botón eliminar producto")
            .locatedBy("//button[text()='REMOVE']");

    public static final Target CHECKOUT = Target.the("Botón eliminar producto")
            .locatedBy("//a[text()='{0}']");

    public static final Target INPUT_DATOS = Target.the("Imput para ingresar usser y password")
            .locatedBy("//input[@placeholder='{0}']");

    public static final Target CONTINUAR = Target.the("Continuar")
            .locatedBy("//input[@value='CONTINUE']");

    public static final Target TITULO_FINALIZACION = Target.the("Finalizacion compra")
            .locatedBy("//h2");

}
