# Travel agency API

![lenguage java8](https://img.shields.io/badge/language-java8-orange.svg) ![framework spark](https://img.shields.io/badge/framework-spark-green.svg) ![build Gradle](https://img.shields.io/badge/build-Gradle-blue.svg)

[Como ejecutar la api?](doc/comands.md)

[Posibles mejoras](doc/improvements.md)

## Endpoint

Dado un destino te devuelve una lista de hoteles y reservas de vuelos.

```
GET /travel_agency/info?destiny={destiny}
```

### Parametro:
* destiny (Tipo String - obligatorio)

### Respuesta valida
```json
{
    "reservations": [
        {
            "id": "{string}",
            "date": "{date}"
        },
        ...
    ],
    "hotels": [
        {
            "name": "{string}",
            "address": "{string}"
        },
        ...
    ]
}
```
Ejemplo:
```json
{
    "reservations": [
        {
            "id": "3ed3a9c4-f7fb-4ed7-8edf-8cdb1375c365",
            "date": "2019-10-11T15:41:05.000715"
        },
        {
            "id": "d8c786e9-be71-43b2-9ece-f044c7e821a1",
            "date": "2019-10-16T14:45:22.000495"
        }
    ],
    "hotels": [
        {
            "name": "Hotel NH Buenos Aires City",
            "address": "160 Bolívar"
        },
        {
            "name": "Hotel Mérit",
            "address": "Adolfo Alsina 801"
        },
        {
            "name": "Hotel Intercontinental",
            "address": "Moreno 809"
        },
        ...
    ]
}
```

### Respuesta en caso de error
```json
{
    "message": "{string}",
    "error": "{string}",
    "status": "{int}"
}
```

Ejemplo:
```json
{
    "message": "destiny is required.",
    "error": "invalid_param",
    "status": 404
}
```

## Nombre de los test

Para los nombres de los test se utilizo la siguiente convencion:
```
{nombre del metodo}_{lo que esta probando}_{Resultado esperadado}
```

Por ejemplo:
```java
public void findForDestiny_checkNotRepeated_isOk() {}
```










