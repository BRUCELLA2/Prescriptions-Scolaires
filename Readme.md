# Prescriptions Scolaires

## Background

At the beginning of each year (and throughout the year), teachers ask their students to get books for them to study in class. It is very common for books offered by teachers to be out of print and no longer available for purchase. On the one hand, teachers lose their credibility and must urgently adapt and modify the books to be studied at the last minute.

At the beginning of each year (and throughout the year), students and their parents must purchase books prescribed by their teachers. It is very common that the books on offer no longer exist and that a race to the bookshop with an old version on second-hand is organised. Sometimes second-hand books are bought for nothing because the teacher changes his list at the last moment to compensate for the unavailability of new books.

At the beginning of each year (and throughout the year), booksellers receive students and their parents who come to buy the school prescriptions made by teachers. Booksellers must regularly inform parents that the requested edition has not existed for many years and must also manage the dissatisfaction that this causes. Moreover, when books are available, it is common that the bookseller does not have enough stock to satisfy a demand for ten books in a few days.

## Prescriptions Scolaires application

In order to overcome this difficult context regularly affecting teachers, students and their parents and booksellers, I propose to create the Prescriptions Scolaires application.
This application will allow teachers to prepare lists of books in advance and obtain validation of the books they contain by booksellers. When the lists are validated, teachers will be able to print the list from the application and provide it to parents and students.
This application will allow booksellers to validate the availability of the books offered. As a number of staff are associated with the lists, this application will also make it possible to better manage stocks according to what has been prescribed by teachers.
Finally, as a side effect, students and their parents will obtain reliable lists whose books must be available (except in very exceptional cases). No need to race for opportunities. In addition, when visiting bookshops, it is much more likely that books will be present if the bookseller has managed the stock using the Prescriptions Scolaires application.

## Requirement

This project needs :
* Apache Maven 3.5.3
* Tomcat 9.0.16
* Java JDK 8 version 162
* PostgreSQL 11.2
* Spring Framework 5.1.5.RELEASE
* Apache Struts 2.5.20
* Apache CXF 3.3.0
* Apache Log4j 2.11.2
* Bootstrap 4.3.1
* Docker (lastest version)

For production requirement details for each server look at document.pdf in Documentation folder.

## Set-up
### Database

Scripts for database and data creation are in "Database scripts" folder. 
Database user configuration is set in the docker-compose.yml. if you change this configuration, don't forgot to change it in the context.xml in META-INF for the Modern Library Web Services application.

In the Docker folder use this command :
* docker-compose -p presco up -d database

In database server, change port configuration in postgresql.conf. Set it to :
port = 5432

### Prescriptions Scolaires Webservices

In the Docker folder use this command :
* docker-compose -p presco up -d web-service

### Prescriptions Scolaires Enseignants

In the Docker folder use this command :
* docker-compose -p presco up -d web-enseignants

### Prescriptions Scolaires Libraires

In the Docker folder use this command :
* docker-compose -p presco up -d web-libraires

## Running Prescriptions Scolaires 

Prescriptions Scolaires Webservices wsdls can be view here : http://0.0.0.0:8080/prescriptions-scolaires-ws-services/services

Prescriptions Scolaires Enseignants will running on : http://0.0.0.0:8082/prescriptions-scolaires-web-enseignants/

Prescriptions Scolaires Libraires will running on : http://0.0.0.0:8081/prescriptions-scolaires-web-libraires/
