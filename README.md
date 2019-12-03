## Organisational News API
* This is an Organisational News API Application that enables a user to View Departments, Employees and News with the aid of the department_id.

#### Author:
By `Vincent K. Kogei`  Email `Vincentkogei@gmail.com`

## App Description
This Application is a demonstration of many-to-many relationships. Also, it helps to implement the use of an API

## Technologies and frameworks used
1. java 11
2. spark core version 2.6.0
3. Gradle 6.0
4. IntelliJ IDEA Community Edition
5. Postgres database

## BDD
| Inputs        |  Description                                                                                           |
| :---          |                                                                                                   ---: |
| Departments   | Name,description,total-employees `eg Finance Department, Budget and Planning, 15`                      |
| Employees     | Enter name,role,position,2``Kogei, Manager, Budget Controller,2``                                      |
| News          | Enter title,content,writtenBy,type,department_id``Technology,Emerging banking news,Department News,2`` |

## Database setup.
In Postgres SQL:

* CREATE DATABASE news_portal;
* CREATE TABLE departments(id SERIAL PRIMARY KEY,name varchar, description varchar, total_employees int);
* CREATE TABLE employees(id SERIAL PRIMARY KEY, name varchar , role varchar, position varchar, department_id int);
* CREATE TABLE news (id SERIAL PRIMARY KEY,title varchar, content varchar, writtenBy varchar,type varchar,department_id int);

## Testing
Use junit testing framework with the command below:
* gradle test
## App setup Instructions
Follow the following instructions to run the application:
* clone this repository 'https://github.com/mervinkogei/Organisational-News-Portal-API.git'
* cd into the cloned directory
* Open with preferred java Intellij Community in case you are interested in making some modifications
* Run the application using gradle

## License
[MIT LICENCE](license) && Copyright &copy;2019
