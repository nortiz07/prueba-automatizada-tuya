# language: es
Característica: Consumir servicio POST de JSONPlaceholder

  Escenario: Crear un nuevo post y validar la respuesta
    Dado que quiero crear un nuevo post
    Cuando envío una solicitud POST al endpoint "/posts" con los datos:
      | userId | title              | body                |
      | 1      | "Nuevo post"       | "Contenido del post" |
    Entonces el código de respuesta debe ser 201
    Y la respuesta debe contener el título "Nuevo post"