DROP TABLE IF EXISTS automovel;

CREATE TABLE automovel(
	id BIGINT(4) PRIMARY KEY AUTO_INCREMENT,
	marca varchar(50) NOT NULL,
	modelo varchar(50) NOT NULL,
	valor decimal(10,2) NOT NULL,
	data_criado timestamp NOT NULL
);

INSERT INTO automovel (marca, modelo, valor, data_criado) VALUES ('Volkswagen', 'Golf', 40000.50, SYSDATE),
								 ('Fiat', 'Uno', 20000.50, SYSDATE);