-- Forneça uma expressão SQL para buscar o nome de todos os animais. Caso o animal possuir pai, mostrar o nome e data de nascimento do pai. Caso não possua pai, mostrar apenas o nome do animal com os dados do pai em branco/nulo.

SELECT a.nomeanimal, p.nomeanimal as nome_pai, p.dtnascanimal as data_nasc_pai 

from animais a

LEFT JOIN animais p ON a.codanimalpai = p.codanimal;

