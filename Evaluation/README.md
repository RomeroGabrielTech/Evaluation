# Evaluación
Evaluación JAVA

Desarrollo de una aplicación que exponga una API RESTful de creación de usuarios.

Todos los endpoints aceptan y retornan solamente JSON, inclusive para los mensajes de
error.

Base de Datos

El manejador de base de datos utilizado es H2
Se crea la base de datos llamada persons en un directorio en la raiz del disco C llamado DB

Los script de SQL utilizados para crear la tabla son:

CREATE TABLE IF NOT EXISTS persons
(
id_person INT NOT NULL,
name VARCHAR(50) NOT NULL,
email VARCHAR(35) NOT NULL,
password VARCHAR(37) NOT NULL,
PRIMARY KEY(id_person)
);

CREATE TABLE IF NOT EXISTS phone
(
id_phone INT NOT NULL,
number VARCHAR(8) NOT NULL,
citycode VARCHAR(2) NOT NULL,
contrycode VARCHAR(4) NOT NULL,
id_person INT NOT NULL,
FOREIGN KEY (id_person) REFERENCES persons(id_person) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY(id_phone)
);

CREATE INDEX i_person ON phone(id_phone);

insert into persons(id_person,name,email,password)values(1,'Juan Rodriguez','juan@rodriguez.org','hunter2');
insert into persons(id_person,name,email,password)values(2,'Gabriel Romero','gabriel@romero.net','hunter1');
insert into persons(id_person,name,email,password)values(3,'Enrique Canelon','enrique@canelon.com','hunter3');

insert into phone(id_phone,number,citycode,contrycode,id_person)values(1,1234567,1,57,1);
insert into phone(id_phone,number,citycode,contrycode,id_person)values(2,7654321,2,58,2);
insert into phone(id_phone,number,citycode,contrycode,id_person)values(3,9876543,9,56,3);
