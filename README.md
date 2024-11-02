# Mutant Detector API

Este proyecto permite detectar si un humano es mutante basado en su secuencia de ADN. El proyecto se divide en tres niveles:

1. **Nivel 1**: Implementa un método `isMutant(String[] dna)` que analiza secuencias de ADN para detectar mutantes.
2. **Nivel 2**: Expone un endpoint REST `/mutant/` que permite verificar secuencias de ADN.
3. **Nivel 3**: Agrega persistencia en base de datos y estadísticas de ADN verificadas, con soporte para alta concurrencia.

## Descripción

Este proyecto está diseñado para determinar si una persona es mutante en función de su ADN, mediante una API REST en Java Spring Boot. La API permite:
- Verificar si un ADN es mutante.
- Registrar cada ADN verificado en una base de datos H2.
- Obtener estadísticas sobre las verificaciones realizadas.

## Consolas de la base de datos H2

Puedes acceder a la consola de la base de datos H2 para ver y gestionar los datos almacenados:

- **Local**: [http://localhost:8080/h2-console/](http://localhost:8080/h2-console/)
- **Producción (Render)**: [https://restinicial.onrender.com/h2-console/](https://restinicial.onrender.com/h2-console/)

## Uso de la API con Postman

Para realizar peticiones a la API, puedes usar Postman en el entorno local y en producción. A continuación, se detallan los enlaces para cada uno:

### Endpoint `/mutant/`

Este endpoint verifica si el ADN proporcionado pertenece a un mutante.

- **URL (Producción)**: `https://parcialmagneto-iau9.onrender.com/mutant`
- **URL (Local)**: `http://localhost:8080/mutant`
- **Método HTTP**: `POST`
- **Body** (Formato JSON):
   ```json
   {
     "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
   }
