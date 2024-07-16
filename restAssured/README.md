# InditexPrueba
#Descripción
Este proyecto es una configuración básica para un proyecto Maven que utiliza RestAssured para pruebas de servicios RESTful. RestAssured es una biblioteca Java que simplifica la validación de servicios RESTful. El objetivo es hacer unas pruebas sobre la API petstore.swagger.io/v2

#Estructura del Proyecto
El fichero pom.xml del proyecto define las dependencias necesarias para trabajar con RestAssured y Jackson, una biblioteca para el procesamiento de JSON en Java.

#Requisitos
Para poder compilar y ejecutar este proyecto, necesitarás tener instalado:

Java 8 o superior
Apache Maven 3.6.0 o superior

#Dependencias

El proyecto incluye las siguientes dependencias:
1. RestAssured: Para realizar pruebas de servicios RESTful.
2. Jackson Core: Para procesamiento básico de JSON.
3. Jackson Databind: Para vincular datos JSON a objetos Java.

#Instalación
Para clonar y ejecutar este proyecto, sigue estos pasos:

1. Clona el repositorio: 
git clone https://github.com/eliaparra/InditexPrueba.git
2. Navega al directorio del proyecto:
cd restAssured
3. Compila el proyecto utilizando Maven:
mvn clean install

#Uso

Puedes ejecutar las pruebas utilizando el siguiente comando:

mvn test

