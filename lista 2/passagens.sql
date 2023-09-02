 create database passagens;
 
 create table empresas (
 	codEmpresa integer NOT NULL PRIMARY KEY,
	nome varchar(100) NOT NULL,
	autorizacao integer NOT NULL	 
 );
 
create table trechos (
	codTrecho integer NOT NULL PRIMARY KEY,
	cidaeOrigem varchar(100) NOT NULL,
	cidadeDestino varchar(100) NOT NULL,
	codEmpresa integer NOT NULL,
	FOREIGN KEY (codEmpresa) REFERENCES empresas (codEmpresa)
);

create table passageiros (
	codPass integer NOT NULL PRIMARY KEY,
	nome varchar(100) NOT NULL,
	idade integer,
	passResponsavel integer,
	FOREIGN KEY (passResponsavel) REFERENCES passageiros (codPass)
);

create table bilhetes (
	codReserva integer NOT NULL PRIMARY KEY,
	dataEmissao date NOT NULL,
	preco decimal NOT NULL,
	poltrona integer NOT NULL,
	codTrecho integer NOT NULL,
	FOREIGN KEY (codTrecho) REFERENCES trechos (codTrecho),
	codPass integer NOT NULL,
	FOREIGN KEY (codPass) REFERENCES passageiros (codPass)	
);

ALTER TABLE trechos
RENAME COLUMN cidaeOrigem TO cidadeOrigem;
