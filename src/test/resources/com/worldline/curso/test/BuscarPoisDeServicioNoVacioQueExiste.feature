# language: es

Característica: Encontrar los Poi de Un Servicio que existe y tiene POIs

Escenario: Obtener los Pois del Servicio Buenos Aires Turistica
	Dado Recibo un consulta de un servicio 
	Cuando el servicio es Buenos Aires Turistica
	Entonces devuelve la lista de POIs:
	|POI|Latitud|Longitud|
	|Las Cuartetas|-34.603750|-58.378575|
	|El Cuartito|-34.597828|-58.385435|
	|El Palacio de la Pizza|-34.603290|-58.377388|
	|Bombonera|-34.635611|-58.364713|
	|Estadio de Vélez|-34.635362|-58.520740|
	|Monumental|-34.545262|-58.449753|
	|Obelisco|-34.603765|-58.381624|

Escenario: Obtener los Pois del Servicio Buenos Aires Histórica
	Dado Recibo un consulta de un servicio 
	Cuando el servicio es Buenos Aires Turistica
	Entonces devuelve la lista de POIs:
	|POI|Latitud|Longitud|
	|Cabildo|-34.608808|-58.373833|
	|Convento de Santo Domingo|-34.612571|-58.371842|
	|Catedral Metropolitana|-34.607569|-58.373257|
	|Café los Angelitos|-34.609590|-58.396192|