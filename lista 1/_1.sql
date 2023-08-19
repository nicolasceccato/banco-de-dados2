-- Forneça duas expressões SQL que sejam capazes de mostrar a maior expectativa de vida dentre todas as espécies cadastradas. Em ambas as soluções, não é permitido usar subconsultas nem mesmo limit/top.

SELECT e.nomeespecie, e.expectativaespecie

FROM especies e

LEFT JOIN especies e2 ON e.expectativaespecie < e2.expectativaespecie

WHERE e2.expectativaespecie IS NULL; 

----------------------------------------------------------------------------

SELECT e1.nomeespecie, e1.expectativaespecie

FROM especies e1

JOIN especies e2 ON e1.expectativaespecie <= e2.expectativaespecie

GROUP BY e1.nomeespecie, e1.expectativaespecie

HAVING COUNT(DISTINCT e2.expectativaespecie) = 1;

