-- Forneça uma expressão SQL para buscar o código e nome dos medicamentos que foram prescritos mais de uma vez. Forneça uma solução que não utilize a cláusula WHERE.

SELECT m.codmedicamento, m.nomemedicamento
FROM medicamentos m
JOIN prescricao p ON m.codmedicamento = p.codmedicamento
GROUP BY m.codmedicamento, m.nomemedicamento
HAVING COUNT(p.codconsulta) > 1;