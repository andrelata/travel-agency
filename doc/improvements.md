# Mejoras en la integración con la api de reservas

* Lo ideal seria tener un servicio de reservas que no pierda información. Que tenga alguna bd donde guarde 
todas las reservas y no se delegue esa informacion al cliente de esa api. Tambien estaria bueno agregarle algun 
query param al endpoint de reserva para poder filtrar por destino, asi evitar traer un monton de información que 
no seria relevante en ese momento por lo menos para el uso que le estamos dando nosotros a la api.
* Si el servicio de reserva no se puede cambiar, capaz se podria analizar la posibilidad de tener un feed 
escuchando al api de reservas y cada n tiempo si aparecen nuevas reservas activar un job que guarde las 
nuevas reservas en la bd. De esta forma cada vez que hariamos el api call vendrian menos reservas ya que nos aseguramos 
que cada n tiempo estamos llamando a reservas y solo aparecerian las nuevas. Posibles problemas encontrar 
cual es el n adecuado para hacer esto y no perder reservas en el medio si se realiza algun 
api call al endpoint de travel_agency.

# Posibles mejoras generales

* No esta bueno usar gson y jackson, lo ideal seria unificarlos. En general me inclino por usar gson pero 
tenia algunos problemas para parsear el response con el rest-client de jax-rs.
* No esta bueno usar la libreria date de java, es mejor usar la nueva libreria time pero esta libreria tiene algunos
problemas con el parseo usando jackson.
* Se podria ajustar el servicio de reservas de vuelo solo teniendo en cuenta las reservas que son validas para 
la fecha actual.
* Habria que analizar si tiene sentido tener una politica de retry para los api call a reservas y hoteles. 
Tambien analizar si queremos devolver un poco mas de info en la respuesta de la api si alguno de los 2 endpoints falla. 
Hoy devuelve el error generico por exception.
* En el DestinyService se podria llamar o analizar llamar a los servicios de reservas y hoteles asincronicamente y 
ver si esto mejora los tiempos de respuesta de la api.
* En el FlightReservationService se podria desacoplar el save de la BD de la consulta de la BD, si el save es muy lento
estas penalizando el rendimiento cuando la informacion ya la tenes para responder.
* Usar una bd real en vez de un set en memoria.