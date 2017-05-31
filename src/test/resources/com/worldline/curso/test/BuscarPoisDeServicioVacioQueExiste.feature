# language: es

Característica: Encontrar los Poi de Un Servicio que existe y está vacío

Escenario: Obtener los Pois de Un Servicio que existe
	Dado Recibo un consulta de un servicio 
	Cuando el servicio es Buenos Aires Tango
	Entonces devuelve la lista de POIs:
	|POI|Latitud|Longitud|
 