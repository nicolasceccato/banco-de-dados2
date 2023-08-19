-- Forneça uma expressão SQL para buscar o código e nome dos funcionários que atenderam animais da espécie 'Hipopótamo'. Forneça uma solução que não utilize subconsultas.

SELECT f.matricula, f.nome
FROM funcionarios f
JOIN consultas c ON f.matricula = c.matricula
JOIN animais a ON c.codanimal = a.codanimal
JOIN especies e ON a.codespecie = e.codespecie
WHERE e.codespecie = 1;