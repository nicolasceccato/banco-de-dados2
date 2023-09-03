create database academia;

use academia;

CREATE TABLE alunos (
    cpf VARCHAR(11) PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    data_nasc DATE NOT NULL,
    cep VARCHAR(8) NOT NULL,
    rua VARCHAR(255) NOT NULL,
    numero_casa VARCHAR(10) NOT NULL,
    bairro VARCHAR(255) NOT NULL
);

CREATE TABLE Treinos (
    id_treino VARCHAR(11) PRIMARY KEY NOT NULL,
    nome_treino VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    duracao_min INT(3) NOT NULL
);

ALTER TABLE Treinos
MODIFY COLUMN duracao_min INT;

RENAME TABLE Treinos TO treinos;

CREATE TABLE instrutores (
    matricula VARCHAR(11) PRIMARY KEY NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    data_nasc DATE NOT NULL,
    cep VARCHAR(8) NOT NULL,
    rua VARCHAR(255) NOT NULL,
    numero_casa VARCHAR(6) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cargo VARCHAR(255) NOT NULL,
    especialidade VARCHAR(255) NOT NULL
);

CREATE TABLE pagamentos (
    id_pagamento VARCHAR(11) PRIMARY KEY NOT NULL,
    data_pagamento DATE NOT NULL,
    valor_pagamento DECIMAL(7, 2) NOT NULL
);

CREATE TABLE aluno_treino (
    cpf VARCHAR(11),
    id_treino VARCHAR(11),
    PRIMARY KEY (cpf, id_treino),
    FOREIGN KEY (cpf) REFERENCES alunos(cpf),
    FOREIGN KEY (id_treino) REFERENCES treinos(id_treino)
);

CREATE TABLE planos (
    id_plano VARCHAR(11) PRIMARY KEY NOT NULL,
    nome_plano VARCHAR(50) NOT NULL,
    descricao VARCHAR(255) NOT NULL
);


CREATE TABLE aluno_plano (
    cpf VARCHAR(11),
    id_plano VARCHAR(11),
    PRIMARY KEY (cpf, id_plano),
    FOREIGN KEY (cpf) REFERENCES alunos(cpf),
    FOREIGN KEY (id_plano) REFERENCES planos(id_plano)
);

CREATE TABLE pagar (
    id_plano VARCHAR(11),
    id_pagamento VARCHAR(11),
    PRIMARY KEY (id_plano, id_pagamento),
    FOREIGN KEY (id_plano) REFERENCES Planos(id_plano),
    FOREIGN KEY (id_pagamento) REFERENCES Pagamentos(id_pagamento)
);

CREATE TABLE instrutores_treinos (
    id_treino VARCHAR(11),
    matricula VARCHAR(11),
    PRIMARY KEY (id_treino, matricula),
    FOREIGN KEY (id_treino) REFERENCES Treinos(id_treino),
    FOREIGN KEY (matricula) REFERENCES Instrutores(matricula)
);





