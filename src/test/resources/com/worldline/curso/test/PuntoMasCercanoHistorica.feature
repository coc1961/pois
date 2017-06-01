# language: es

Característica: Encontrar el Poi de Un Servicio más cercano a las coordenadas del usuario

Escenario: Obtener el Poi de Un Servicio en funcion de las coordenadas y servicio de un usuario
  Dado un usuario suscripto al servicios Buenos Aires Historica y el usuario está ubicado en -34.608333333333 -58.371944444444
  Entonces se devuelve
  |nombre|latitud|longitud|
  |Catedral Metropolitana|-34.607569|-58.373257|
