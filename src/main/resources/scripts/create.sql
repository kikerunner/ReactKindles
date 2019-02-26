create table IF NOT EXISTS USER(
	dni varchar(25) PRIMARY KEY,
	nombre varchar(25),
	apellido varchar(25)
);


create table IF NOT EXISTS KINDLES(
	serial INT PRIMARY KEY,
	model varchar(25),
	inches varchar(25)
);