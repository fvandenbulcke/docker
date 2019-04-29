##########################################################
##########          CREATION DE LA BDD          ##########
##########################################################

CREATE DATABASE library;

###########################################################
##########          CREATION DES TABLES          ##########
###########################################################


CREATE TABLE library.students (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	creation_date DATETIME,
	class_level VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE library.books (
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255),
	year INT(4) NOT NULL,
	isbn bigint NOT NULL,
	author VARCHAR(255) NOT NULL,
	editor VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE library.borrows (
	id INT NOT NULL AUTO_INCREMENT,
	student_id INT NOT NULL,
	book_id INT NOT NULL,
	start_date DATETIME NOT NULL,
	end_date DATETIME,
	PRIMARY KEY (id)
);

ALTER TABLE library.borrows ADD CONSTRAINT borrows_fk0 FOREIGN KEY (student_id) REFERENCES library.students(id);
ALTER TABLE library.borrows ADD CONSTRAINT borrows_fk1 FOREIGN KEY (book_id) REFERENCES library.books(id);


###########################################################
##########         INSERTION DES STUDENT         ##########
###########################################################

insert into library.students (first_name,name,creation_date,class_level) values ('Margaret','Thatcher','1700-7-4 04:13:54',3);
insert into library.students (first_name,name,creation_date,class_level) values ('Stephen','Hawking','1962-1-2 04:13:54',3);
insert into library.students (first_name,name,creation_date,class_level) values ('Bill','Clinton','1968-3-4 04:13:54',5);
insert into library.students (first_name,name,creation_date,class_level) values ('Rowan','Atkinson','1970-10-13 04:13:54',4);
insert into library.students (first_name,name,creation_date,class_level) values ('Tony','Blair','1975-7-23 04:13:54',2);


###########################################################
##########         INSERTION DES LIVRES          ##########
###########################################################


INSERT INTO library.books (title,year,isbn,author,editor) VALUES ('The Hunger Games',2008,0439023483,'Suzanne Collins','Alan Bell');
INSERT INTO library.books (title,year,isbn,author,editor) VALUES ('Harry Potter and the Order of the Phoenix',2003,0439358078,'J.K. Rowling','Gallimard');
INSERT INTO library.books (title,year,isbn,author,editor) VALUES ('Memoirs of a Geisha',1997,1400096898,'Arthur Golden','Vintage');
INSERT INTO library.books (title,year,isbn,author,editor) VALUES ('Twilight',2006,0316015849,'Stephenie Meyer','Little, Brown Books for Young Readers');
INSERT INTO library.books (title,year,isbn,author,editor) VALUES ('The Lord of the Rings',1954,9780544003415,'J.R.R. Tolkien','HarperCollins Publishers Ltd');


###########################################################
##########         INSERTION DES EMPRUNTS        ##########
###########################################################



















