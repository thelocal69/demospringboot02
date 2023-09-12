CREATE DATABASE test_db;

USE test_db;

CREATE TABLE author(
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       authorname VARCHAR(155),
                       fullname VARCHAR(155),
                       gender VARCHAR(155)
);

CREATE TABLE news(
                     id INT PRIMARY KEY AUTO_INCREMENT,
                     title VARCHAR(255),
                     content TEXT,
                     author_id INT NOT NULL,
                     createddate TIMESTAMP
);

ALTER TABLE news ADD CONSTRAINT fk_authorid_news FOREIGN KEY (author_id) REFERENCES author(id);