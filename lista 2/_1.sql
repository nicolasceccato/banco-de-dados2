-- Elabore uma consulta que mostre os códigos de passageiro e as quantidades de bilhetes emitidos por cada passageiro.

SELECT codPass, COUNT(*) quantidade_de_bilhetes
FROM bilhetes
GROUP BY codPass;