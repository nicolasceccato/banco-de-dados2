--Forneça uma expressão em SQL que retorne o ano e a quantidade de participantes de pares de edições 
--diferentes que ocorreram na mesma cidade.
--Garante que um mesmo par não apareça na resposta, nem mesmo em posições inversas.

--Exemplo de retorno da expressão:

--ano 	qtdparticipantes  	ano  	qtdparticipantes 
--2005  250	                2015   	310
--2010	208	                2018 	150
-- ...	... 	 	 
SELECT
    e1.ano AS ano1,
    e1.qtdparticipantes AS qtdparticipantes1,
    e2.ano AS ano2,
    e2.qtdparticipantes AS qtdparticipantes2
FROM
    edicoes e1
JOIN
    edicoes e2 ON e1.ano < e2.ano AND e1.cidade = e2.cidade
ORDER BY
    e1.ano, e2.ano;