-- Elabore uma consulta que mostre o nome e código dos passageiros que possuem bilhetes 
-- para o trecho Joinville-Porto Alegre (cidade origem - cidade destino) oferecido pela empresa cujo número de autorização é 541.

SELECT p.nome, p.codPass 
FROM passageiros p
JOIN bilhetes b ON p.codPass = b.codPass
JOIN trechos t ON b.codTrecho = t.trechos
JOIN empresas e ON t.codEmpresa = e.codEmpresa
WHERE t.cidadeOrigem = 'JOINVILLE' AND t.cidadeDestino = 'Porto Alegre' AND e.autorizacao = 541; 