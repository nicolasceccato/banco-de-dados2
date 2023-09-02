-- Elabore uma consulta que mostre pares de cidadeOrigem e cidadeDestino de Trechos diferentes,
-- mas que são oferecidos por uma mesma empresa. Garanta que um mesmo par não irá se repetir na resposta, nem mesmo em posições diferentes.

SELECT DISTINCT t1.cidadeOrigem, t1.cidadeDestino 
FROM trechos t1
INNER JOIN trechos t2 ON t1.codEmpresa = t2.codEmpresa
WHERE t1.cidadeOrigem <> t2.cidadeOrigem
    AND t1.cidadeDestino <> t2.cidadeDestino
    AND t1.cidadeOrigem <> t2.cidadeDestino
    AND t1.cidadeDestino <> t2.cidadeOrigem; 