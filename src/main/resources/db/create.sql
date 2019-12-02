 SET MODE PostgreSQL;

CREATE DATABASE news_portal;

\c news_portal;

CREATE TABLE IF NOT EXISTS departments (
 id serial PRIMARY KEY,
 name VARCHAR,
 description VARCHAR,
 total_employees int
 );

CREATE TABLE IF NOT EXISTS employees(
id serial PRIMARY KEY,
name VARCHAR,
position VARCHAR,
role vARCHAR,
department_id int
);

CREATE TABLE IF NOT EXISTS news(
id serial PRIMARY KEY,
title VARCHAR,
content VARCHAR,
writtenBy VARCHAR,
department_id int
);