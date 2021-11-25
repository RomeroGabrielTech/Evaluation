# Evaluación
Evaluación JAVA


## Enunciado:

Desarrollo de una aplicación que exponga una API RESTful de creación de usuarios.

Todos los endpoints aceptan y retornan solamente JSON, inclusive para los mensajes de
error.

## Registro

● Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña",
más un listado de objetos "teléfono", respetando el siguiente formato:
{
	"name": "Juan Rodriguez",
	"email": "juan@rodriguez.org",
	"password": "hunter2",
	"phones": [
		{
			"number": "1234567",
			"citycode": "1",
			"contrycode": "57"
		}
	]
}

● Responder el código de status HTTP adecuado
● En caso de éxito, retorne el usuario y los siguientes campos:
○ id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería
más deseable un UUID)
○ created: fecha de creación del usuario
○ modified: fecha de la última actualización de usuario
○ last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la
fecha de creación)
○ token: token de acceso de la API (puede ser UUID o JWT)
○ isactive: Indica si el usuario sigue habilitado dentro del sistema.
● Si caso el correo conste en la base de datos, deberá retornar un error "El correo ya
registrado".
● El correo debe seguir una expresión regular para validar que formato sea el correcto.
(aaaaaaa@dominio.cl)
● La clave debe seguir una expresión regular para validar que formato sea el correcto. (El
valor de la expresión regular debe ser configurable)
● El token deberá ser persistido junto con el usuario

## Requisitos

● Plazo: 2 días, si tienes algún inconveniente con el tiempo comunicate con nosotros
● Banco de datos en memoria. Ejemplo: HSQLDB o H2.
● Proceso de build vía Gradle o Maven.
● Persistencia con JPA. Ejemplo: EclipseLink, Hibernate u OpenJPA.
● Framework SpringBoot.
● Java 8+
● Entrega en un repositorio público (github o bitbucket) con el código fuente y script de
creación de BD.
● Readme explicando cómo probarlo.
● Diagrama de la solución.

## Requisitos opcionales

● JWT como token
● Pruebas unitarias
● Swagger

## Base de Datos

El manejador de base de datos utilizado es H2
Se crea la base de datos llamada persons en un directorio en la raiz del disco C llamado DB

Los script de SQL utilizados para crear la tabla son:

![image](https://user-images.githubusercontent.com/60945095/143494243-5887d82d-3f8b-4b7a-af6e-109f68e66726.png)

## Documentación Swagger 2.0

<img width="561" alt="image" src="https://user-images.githubusercontent.com/60945095/143494614-c842b425-dcc2-422d-9093-32760d58187c.png">


// 20211125171327
// http://localhost:8099/v2/api-docs

{
  "swagger": "2.0",
  "info": {
    "description": "Swagger. Documentación Evaluación: JAVA",
    "version": "1.0",
    "title": "Documentación Evaluación: JAVA",
    "contact": {
      "name": "Gabriel Romero",
      "url": "https://gromero.tech",
      "email": "ing.gabriel.romero@gmail.com"
    },
    "license": {
      "name": "Apache Livense Version 2.0"
    }
  },
  "host": "localhost:8099",
  "basePath": "/",
  "tags": [
    {
      "name": "peoples-rest",
      "description": "Peoples REST"
    }
  ],
  "paths": {
    "/allPeople": {
      "get": {
        "tags": [
          "peoples-rest"
        ],
        "summary": "getPeoples",
        "operationId": "getPeoplesUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "array",
              "items": {
                "$ref": "#/definitions/Peoples"
              }
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        },
        "deprecated": false
      }
    },
    "/save": {
      "post": {
        "tags": [
          "peoples-rest"
        ],
        "summary": "createPeople",
        "operationId": "createPeopleUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "peoples",
            "description": "peoples",
            "required": true,
            "schema": {
              "$ref": "#/definitions/Peoples"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/Peoples"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        },
        "deprecated": false
      }
    }
  },
  "definitions": {
    "Peoples": {
      "type": "object",
      "properties": {
        "created": {
          "type": "string",
          "format": "date-time"
        },
        "email": {
          "type": "string"
        },
        "id": {
          "type": "string",
          "format": "uuid"
        },
        "isactive": {
          "type": "boolean"
        },
        "last_login": {
          "type": "string",
          "format": "date-time"
        },
        "modified": {
          "type": "string",
          "format": "date-time"
        },
        "name": {
          "type": "string"
        },
        "password": {
          "type": "string"
        },
        "token": {
          "type": "string"
        }
      },
      "title": "Peoples"
    }
  }
}
