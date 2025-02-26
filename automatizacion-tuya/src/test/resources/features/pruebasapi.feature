# language: es
Característica: Consumir servicio POST de JSONPlaceholder

  Escenario: Consumir el servicio POST y validar la respuesta
    Dado que el usuario quiere llamar el api
    Cuando envía la solicitud con título "Nuevo Post"
    Entonces el código de respuesta debe ser 201
    Y la respuesta debe contener el campo title con el valor "Nuevo Post"

  Esquema del escenario: : Consumir el servicio GET y validar la respuesta
    Dado que el usuario quiere llamar el api
    Cuando cuando consulta el usuario "<id>"
    Entonces el código de respuesta debe ser 200
    Y la respuesta debe contener el campo id con el valor "<id>"

    Ejemplos:
      | id |
      | 10 |
      | 2  |
      | 4  |