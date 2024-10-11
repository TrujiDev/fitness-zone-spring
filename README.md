# Aplicación Fitness Zone

**Fitness Zone** es una aplicación de línea de comandos desarrollada con Spring Boot que permite a los usuarios gestionar la información de los clientes de un gimnasio. Esta aplicación proporciona funcionalidades para agregar, actualizar, eliminar y encontrar clientes, convirtiéndose en una herramienta esencial para la administración de gimnasios.

## Funcionalidades

- **Gestión de Clientes**: Gestiona fácilmente los registros de los clientes, incluyendo la adición de nuevos clientes, la actualización de información existente y la eliminación de registros.
- **Funcionalidad de Búsqueda**: Encuentra clientes por su ID para acceder rápidamente a su información.
- **Interfaz Amigable**: Interfaz de línea de comandos que guía a los usuarios a través de varias opciones con mensajes claros y retroalimentación.
- **Registro de Actividad**: Registro integrado con SLF4J para seguir la actividad de la aplicación y los errores, asegurando una mejor depuración y monitoreo.

## Tecnologías Utilizadas

- **Spring Boot**: Marco utilizado para construir la aplicación.
- **Java**: Lenguaje de programación principal.
- **Spring Data JPA**: Para el acceso a datos e interacción con la base de datos MySQL.
- **MySQL**: Base de datos utilizada para almacenar la información de los clientes.
- **Maven**: Herramienta de gestión de dependencias y automatización de construcción.

## Guía para Comenzar

Para comenzar con la aplicación Fitness Zone, clona el repositorio y ejecuta la aplicación utilizando Maven. Asegúrate de configurar la conexión a la base de datos en `application.properties`.

### Requisitos Previos

- Java Development Kit (JDK) 11 o posterior
- Servidor de Base de Datos MySQL
- Maven

### Instalación

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/TrujiDev/fitness-zone-spring.git
   cd fitness-zone-spring
   ```

2. **Configura tu base de datos MySQL**:
   Edita el archivo `src/main/resources/application.properties` para establecer la conexión a tu base de datos:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/fitness_zone
   spring.datasource.username=<tu_usuario>
   spring.datasource.password=<tu_contraseña>
   ```

3. **Ejecuta la aplicación**:
   Usa el siguiente comando para iniciar la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

[!NOTA] **Inicialización de la Base de Datos**: Asegúrate de que tu base de datos MySQL esté configurada y que el esquema se cree según los requisitos de la aplicación.

## Uso

Después de iniciar la aplicación, se te presentará un menú para elegir varias opciones relacionadas con la gestión de clientes. Sigue los mensajes para interactuar con la aplicación.

### Comandos Disponibles

1. **Lista de Clientes**: Ver todos los clientes.
2. **Buscar un Cliente**: Buscar un cliente por ID.
3. **Agregar un Cliente**: Introducir detalles para agregar un nuevo cliente.
4. **Actualizar un Cliente**: Modificar los detalles de un cliente existente.
5. **Eliminar un Cliente**: Eliminar un cliente de los registros.
6. **Salir**: Salir de la aplicación.

## Contribuciones

¡Las contribuciones son bienvenidas! Si deseas contribuir a la aplicación Fitness Zone, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama para tu funcionalidad o corrección de errores:
   ```bash
   git checkout -b mi-rama-de-funcionalidad
   ```
3. Realiza tu commit de cambios:
   ```bash
   git commit -m "Agregar alguna funcionalidad"
   ```
4. Haz push a la rama:
   ```bash
   git push origin mi-rama-de-funcionalidad
   ```
5. Abre una solicitud de extracción (pull request).

## Licencia

Este proyecto no cuenta con ninguna licencia específica. Si deseas utilizar o contribuir a este proyecto, siéntete libre de hacerlo bajo tu propio riesgo.