-- Forneça uma expressão SQL para buscar o nome dos funcionários que têm consulta marcada. Para cada funcionário, além do nome mostrar a quantidade total de consultas que ele tem.

SELECT f.nome, COUNT(c.codconsulta) AS quantidade_consultas
FROM funcionarios f
JOIN consultas c ON f.matricula = c.matricula
GROUP BY f.nome;