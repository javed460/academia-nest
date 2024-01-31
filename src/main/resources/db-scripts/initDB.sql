create database sms;

CREATE TABLE sms.Users (
    id int NOT NULL AUTO_INCREMENT,
    Username varchar(255),
    Password varchar(255),
    PRIMARY KEY ( id )
);

CREATE TABLE sms.Student (
    id int NOT NULL AUTO_INCREMENT,
    studentName varchar(255),
    studentClass varchar(255),
    dob varchar(10),
    PRIMARY KEY ( id )
);

