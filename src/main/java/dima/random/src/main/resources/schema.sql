DROP TABLE IF EXISTS students;

CREATE TABLE  students(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(250) NOT NULL,
surname VARCHAR(250) NOT NULL,
isPresent VARCHAR(250)
);