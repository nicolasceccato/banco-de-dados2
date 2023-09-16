--Formule uma expressão em SQL que retorne o id e título de todos os artigos, 
--bem como o nome dos seus respectivos tipos. Caso o artigo não possua tipo, apresentar o nome do tipo como nulo ou branco.

SELECT ar.artigoid, ar.titulo, ti.nome 
FROM artigos ar 
LEFT JOIN tipos ti 
ON ar.tipoid = ti.tipoid 