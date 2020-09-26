DROP TABLE IF EXISTS boleto;

CREATE TABLE boleto(
	id BIGINT(4) PRIMARY KEY AUTO_INCREMENT,
	marca varchar(50) NOT NULL,
	modelo varchar(50) NOT NULL,
	valor decimal(10,2) NOT NULL,
	data_vencimento timestamp NOT NULL
);