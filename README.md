# Evaluación
Evaluación JAVA

Desarrollo de una aplicación que exponga una API RESTful de creación de usuarios.

Todos los endpoints aceptan y retornan solamente JSON, inclusive para los mensajes de
error.

Base de Datos

El manejador de base de datos utilizado es H2
Se crea la base de datos llamada persons en un directorio en la raiz del disco C llamado DB

Los script de SQL utilizados para crear la tabla son:

	CREATE TABLE IF NOT EXISTS persons (
	id VARCHAR(36) NOT NULL,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(35) NOT NULL,
	password VARCHAR(37) NOT NULL,
	created DATE,
	modified DATE,
	last_login DATE,
	token VARCHAR(36),
	isactive BOOLEAN,
	PRIMARY KEY(id) );
	
	CREATE TABLE IF NOT EXISTS phone (
	Id_phone
	number VARCHAR(8) NOT NULL,
	citycode VARCHAR(2) NOT NULL,
	contrycode VARCHAR(4) NOT NULL,
	id VARCHAR(36) NOT NULL,
	FOREIGN KEY (id) REFERENCES persons(id) ON DELETE CASCADE ON UPDATE CASCADE,
	PRIMARY KEY(id_phone) );
	
	CREATE INDEX id ON phone(id_phone);
	
	insert into persons(id_person,name,email,password)values(1,'Juan Rodriguez','juan@rodriguez.org','hunter2'); 
	insert into persons(id_person,name,email,password)values(2,'Gabriel Romero','gabriel@romero.net','hunter1'); 
	insert into persons(id_person,name,email,password)values(3,'Enrique Canelon','enrique@canelon.com','hunter3');
	insert into phone(id_phone,number,citycode,contrycode,id_person)values(1,1234567,1,57,1); 
	insert into phone(id_phone,number,citycode,contrycode,id_person)values(2,7654321,2,58,2); 
insert into phone(id_phone,number,citycode,contrycode,id_person)values(3,9876543,9,56,3);![image](https://user-images.githubusercontent.com/60945095/143494243-5887d82d-3f8b-4b7a-af6e-109f68e66726.png)

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
