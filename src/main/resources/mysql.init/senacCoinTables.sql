USE projetoIntegrador;

CREATE TABLE IF NOT EXISTS usuario (
	id VARCHAR(255) NOT NULL,
	usuario_cpf VARCHAR(11) NOT NULL,
	usuario_nome_completo VARCHAR(150) NOT NULL,
	usuario_apelino LONGTEXT NOT NULL,
	usuario_email VARCHAR(256) NOT NULL,
	usuario_data_nascimento DATETIME(6) NOT NULL,
	usuario_telefone VARCHAR(20) NOT NULL,
	usuario_data_cadastro DATETIME(6) NOT NULL,
	-- usuario_foto LONGBLOB NOT NULL,
	usuario_status INT(11) NOT NULL,
	user_name VARCHAR(256) NOT NULL,
	PRIMARY KEY (id)

);

CREATE TABLE IF NOT EXISTS senac_coin (
	senac_coin_id BIGINT(20) NOT NULL auto_increment,
	senac_coin_saldo BIGINT(20) NOT NULL,
	senac_coin_status INT(11) NOT NULL,
	usuario_id VARCHAR(255) NOT NULL,
	PRIMARY KEY (senac_coin_id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);


CREATE TABLE IF NOT EXISTS senac_coin_movimentacao (
    senac_coin_movimentacao_id BIGINT(20) NOT NULL auto_increment,
    senac_coin_movimentacao_data DATETIME NOT NULL,
    senac_coin_movimentacao_observacao LONGTEXT NOT NULL,
    senac_coin_movimentacao_valor BIGINT(20) NOT NULL,
    senac_coin_movimentacao_status ENUM('CREDIT', 'DEBT'),
    usuario_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (senac_coin_movimentacao_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);


INSERT INTO projetoIntegrador.usuario
(id, usuario_cpf, usuario_nome_completo, usuario_apelino, usuario_email, usuario_data_nascimento, usuario_telefone, usuario_data_cadastro, usuario_status, user_name)
VALUES('a', '12345678911', 'victor', 'dale', 'a@a.com', '2011-12-18 13:17:17', '212121', '2011-12-18 13:17:17', 0, 'doly');

INSERT INTO projetoIntegrador.senac_coin
(senac_coin_saldo, senac_coin_status, usuario_id)
VALUES(0, 0, 'a');