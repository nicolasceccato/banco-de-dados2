-- Forneça uma expressão SQL para buscar o nome e data de nascimento dos animais que já são avós.

SELECT DISTINCT a.nomeanimal, a.dtnascanimal

FROM animais a

JOIN animais filho ON filho.codanimalpai = a.codanimal OR filho.codanimalmae = a.codanimal

JOIN animais neto ON neto.codanimalpai = filho.codanimal OR neto.codanimalmae = filho.codanimal