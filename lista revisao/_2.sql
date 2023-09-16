--Formule expressões em SQL que retornem o id, nome e gênero de autores que publicaram artigos 
--na edição ocorrida na cidade 
--de 'Joinville'. Forneça pelo menos duas expressões que sejam capazes de retornar estes dados.

--Exemplo de retorno da expressão:

--id	nome	          gênero
--34	Roberta Pereira 	f 
--56	Ronaldo Mello	    m 
--75	Renato Fileto	    m 
-- ...	... 	 

SELECT au.autorid AS id, au.nome AS nome, au.genero AS gênero FROM autores au
JOIN autoresartigo aa ON au.autorid = aa.autorid
JOIN artigos ar ON aa.artigoid = ar.artigoid
JOIN edicoes ed ON ar.edicaoid = ed.edicaoid
WHERE ed.cidade = 'Joinville'

