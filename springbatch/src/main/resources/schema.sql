drop TABLE person;
CREATE TABLE jcala_blog.person (
	id int(11) NOT NULL AUTO_INCREMENT,
	username varchar(100) NULL,
	age int(4) NULL,
	nation varchar(100) NULL,
	address varchar(100) NULL,
	CONSTRAINT person_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci ;

