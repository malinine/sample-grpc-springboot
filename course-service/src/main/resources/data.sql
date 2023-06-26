DROP TABLE IF EXISTS course;
CREATE TABLE course AS SELECT * FROM CSVREAD('classpath:course.csv');