package org.tuya.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaArticulo extends PageObject {

        public static final Target SELECCION_ARTICULO = Target.the("Click para seleccionar articulo")
                .locatedBy("//div[text()='{0}']");
        public static final Target BTN_ADD_CART = Target.the("Boton agregar al carrito")
                .locatedBy("//button[text()='ADD TO CART']");

        public static final Target BTN_CARRITO = Target.the("Boton ingresar al carrito")
                .locatedBy("//a[contains(@class,'shopping_cart_link ')]");

        public static final Target CAMPO_DESCRIP_PRECIO = Target.the("Descripción artículo")
                .locatedBy("//div[@class='{0}']");

        public static final Target AGREGAR_CARRITO_ITEMS = Target.the("Agregar al carrito desde items")
                .locatedBy("(//button[text()='ADD TO CART'])[{0}]");


}
