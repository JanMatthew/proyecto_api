# Proyecto Spring Boot - API REST

## Descripción
Este proyecto es una API REST desarrollada con **Spring Boot** que implementa un CRUD sobre una base de datos con de dos tablas relacionadas. Además, se han incorporado medidas de seguridad, documentación con Swagger, logging y contiene una explicación para lanzarlo como servicio en Linux.

## Requisitos del Proyecto
- CRUD sobre una base de datos con al menos dos tablas relacionadas.
- Implementación de métodos HTTP: **GET, POST, PUT, DELETE**.
- Uso de parámetros en la URL como variables.
- Seguridad en los endpoints mediante **HTTPS**.
- Autenticación y autorización antes de acceder a los endpoints.
- Documentación con **Swagger**.
- Implementación de **Logger** para registrar logs de la API.
- Creación de un **servicio en Linux** para iniciar la API en el arranque del sistema y gestionarla con `systemctl`.

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Spring Data JPA**
- **MariaDb
- **Swagger (Springdoc OpenAPI 3)**
- **Logback para logging**

## Explicación del Proyecto
### Base de Datos
Se ha hecho uso de mariaDb como base de datos, con la cual se han creado dos tablas relacionadas entre sí:
- **Trabajador**: Contiene información básica sobre los empleados.
- **Nómina**: Contiene la información salarial de cada trabajador.

Cada trabajador está asociado a una única nómina, y cada nómina pertenece a un único trabajador, estableciendo así una relación uno a uno entre ambas entidades.

### Métodos CRUD
Se han desarrollado los componentes necesarios para la implementación del CRUD, organizados en:
- **Repository**: Interfaces para la comunicación con la base de datos utilizando Spring Data JPA.
- **Service**: Contiene la lógica de negocio para la gestión de trabajadores y nóminas.
- **Controller**: Expone los endpoints de la API y gestiona las solicitudes HTTP.
- **Model**: Define las entidades de la base de datos y sus relaciones.

Todos los métodos CRUD (`GET`, `POST`, `PUT`, `DELETE`) han sido implementados para permitir la gestión completa de los datos a través de la API.

### HTTPS
Para garantizar la seguridad en la comunicación entre el cliente y la API, se ha implementado **HTTPS**. Esto asegura que todas las peticiones y respuestas estén cifradas, protegiendo la información transmitida. Se recomienda configurar un certificado SSL en el servidor para habilitar HTTPS correctamente. Esto se logra a través del uso de SSL y una clave generada manualmente.

### Autenticación
Para mantener la seguridad de la API y su acceso limitado, se ha creado un proceso de autenticación con un registro y un inicio de sesión. Luego de haberse autenticado con éxito, el usuario recibe un token, el cual es necesario para todas las llamadas CRUD de la API.

### Swagger
Se ha hecho uso de **Swagger** para tener una documentación limpia de la API. Se puede acceder a través de:
```
https://localhost:8080/auth/swagger-ui-custom.html
```

### Logger
Se ha implementado un sistema de **logging** con **Logback**, el cual permite registrar eventos de la API en diferentes niveles (`TRACE`, `DEBUG`, `INFO`, `WARN`, `ERROR`). Esto facilita la depuración, el monitoreo del sistema y la auditoría de eventos importantes.

Los logs generados por la API se encuentran en `logs/application.log` y también pueden visualizarse en tiempo real con:
```bash
tail -f logs/application.log
```

### Crear servicio en Linux para iniciar la API automáticamente
Para crear el servicio Linux de la api lo primero seria generar el archivo bootjar del programa.
Esto se puede hacer desde intelij clicando dos veces en bootjar:

![bootjar](https://github.com/user-attachments/assets/22278999-7f2e-4939-bc0d-825674126a75)

Una vez creado el archivo crear un archivo de servicio en **Systemd**:
```bash
sudo nano /etc/systemd/system/nombre.service
```

En el archivo añadimo el siguiente contenido:
```ini
[Unit]
Description=API Spring Boot Service
After=network.target

[Service]
User=tu_usuario
WorkingDirectory=/ruta/del/proyecto
ExecStart=/usr/bin/java -jar target/mi-api.jar
SuccessExitStatus=143
Restart=always
RestartSec=5

[Install]
WantedBy=multi-user.target
```
En el ExecStart se debe indicar tanto la ruta del jdk en este caso debe ser el 17 como la ruta del jar que hemos creado

Guardar y ejecutar:
```bash
sudo systemctl daemon-reload
sudo systemctl enable api-springboot
sudo systemctl start api-springboot
```
