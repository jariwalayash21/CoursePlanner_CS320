DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS users;


CREATE TABLE courses 
(id integer auto_increment primary key,
course_no varchar(255),
course_name varchar(255),
course_pre varchar(255));

CREATE TABLE users 
(uid integer auto_increment primary key,
username varchar(255),
password varchar(255),
re_password varchar(255),
fname varchar(255),
lname varchar(255));

