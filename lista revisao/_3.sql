--Crie expressões em SQL que retornem o ano e a cidade das edições que tiveram a maior quantidade de participantes. 
--Forneça pelo menos duas expressões que sejam capazes de retornar estes dados.

SELECT ed.ano, ed.cidade 
FROM edicoes ed
WHERE ed.qtdparticipantes = (SELECT (MAX(qtdparticipantes)) FROM edicoes)

SELECT ed.ano, ed.cidade 
FROM edicoes ed
WHERE ed.qtdparticipantes IS NOT NULL 

EXCEPT

SELECT ed.ano, ed.cidade 
FROM edicoes ed JOIN edicoes ed1 ON ed.qtdparticipantes < ed1.qtdparticipantes
