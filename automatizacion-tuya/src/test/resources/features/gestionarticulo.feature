#language: es

Característica: Compra y gestión de artículos en la plataforma SwagLabs
  Como cliente de SwagLabs
  Quiero explorar y comprar artículos
  Para poder gestionar mi carrito y finalizar mi compra

  Antecedentes:
    Dado que el usuario inicia sesión exitosamente en SwagLabs

  Escenario: Validación de precio y descripcion del artículo en el carrito
    Cuando el usuario selecciona el articulo "Sauce Labs Onesie"
    Y el usuario agrega el artículo al carrito
    Y el usuario ingresa al carrito de compras
    Entonces el usuario debería ver la descripción del artículo en el carrito
    Y el usuario debería ver el precio en el carrito

  Escenario: Remover artículo del carrito y de la seccion de artículos
    Cuando el usuario selecciona el articulo "Sauce Labs Onesie"
    Y el usuario agrega el artículo al carrito
    Y el usuario ingresa al carrito de compras
    Y el usuario elimina el artículo del carrito
    Entonces el usuario no debería ver nada en el carrito

  Escenario: Realizar compra con 3 articulos
    Cuando el usuario selecciona tres articulos
    Y el usuario ingresa al carrito de compras
    Y inicia el checkout
    Y ingresa sus datos
    Y finaliza la compra
    Entonces debería ver un mensaje de compra finalizada

