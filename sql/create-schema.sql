/* script to create database movie_cruiser */
CREATE DATABASE IF NOT EXISTS movie_cruiser;

USE movie_cruiser;

/* script to create table user*/
CREATE TABLE IF NOT EXISTS user(
  us_id INT NOT NULL AUTO_INCREMENT,
  us_name VARCHAR(60),
  PRIMARY KEY(us_id)
  );

/* script to create table movie*/
CREATE TABLE IF NOT EXISTS movie(
 mo_id INT NOT NULL AUTO_INCREMENT,
 mo_title VARCHAR(100),
 mo_box_office BIGINT,
 mo_active VARCHAR(3),
 mo_date_of_launch DATE,
 mo_genre VARCHAR(45),
 mo_has_teaser VARCHAR(3),
 PRIMARY KEY(mo_id)
 );
 
 /* script to create table favorites*/
 CREATE TABLE IF NOT EXISTS favorites(
  fa_id INT NOT NULL AUTO_INCREMENT,
  fa_us_id INT,
  fa_mo_id INT,
  PRIMARY KEY(fa_id),
  FOREIGN KEY(fa_us_id) REFERENCES user(us_id),
  FOREIGN KEY(fa_mo_id) REFERENCES movie(mo_id)
  );