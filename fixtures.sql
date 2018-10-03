CREATE TABLE APP.CAMA (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    tipo VARCHAR(30),
    PRIMARY KEY(id)
);

CREATE TABLE APP.SERVICO (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nome VARCHAR(30) UNIQUE NOT NULL,
    descricao VARCHAR(30),
    valor DECIMAL(10, 2),
    PRIMARY KEY(id)
);

CREATE TABLE APP.QUARTO_CAMA (
    id_quarto INT NOT NULL,
    id_cama INT NOT NULL,
    PRIMARY KEY(id_quarto, id_cama)
);

CREATE TABLE APP.QUARTO_ADICIONAIS (
    id_quarto INT NOT NULL,
    adicional VARCHAR(30) NOT NULL,
    PRIMARY KEY(id_quarto, adicional)
);

CREATE TABLE APP.QUARTO (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    numero INT UNIQUE NOT NULL,
    valorDiaria DECIMAL(10, 2),
    tipo VARCHAR(30) NOT NULL,
    ocupado VARCHAR(30) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE APP.USUARIO (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nome VARCHAR(30) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    endereco VARCHAR(60),
    telefone VARCHAR(11),
    PRIMARY KEY(id)
);

CREATE TABLE APP.FUNCIONARIO (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    nome VARCHAR(30) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    endereco VARCHAR(60),
    telefone VARCHAR(11),
    username VARCHAR(30) UNIQUE NOT NULL,
    senha VARCHAR(30) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE APP.ESTADIA (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    usuario INT NOT NULL,
    quarto INT NOT NULL,
    senha INT NOT NULL,
    diarias INT NOT NULL,
    checkout INT,
    fatura DECIMAL(10, 2),
    PRIMARY KEY(id),
    FOREIGN KEY(quarto) REFERENCES APP.QUARTO(id),
    FOREIGN KEY(usuario) REFERENCES APP.USUARIO(id)
);

CREATE TABLE APP.ESTADIA_SERVICOS (
    id_estadia INT NOT NULL,
    id_servico INT NOT NULL,
    PRIMARY KEY(id_estadia, id_servico)
);