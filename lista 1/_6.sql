-- Forneça uma expressão SQL para buscar o nome das especialidades dos funcionários. Para cada especialidade, mostrar também a quantidade de funcionários que ela tem.

SELECT e.especialidade, COUNT(*) AS quantidade_de_funcionarios
FROM funcionarios e
GROUP BY e.especialidade