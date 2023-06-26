DROP TABLE IF EXISTS student;
CREATE TABLE student AS SELECT * FROM CSVREAD('classpath:student.csv');