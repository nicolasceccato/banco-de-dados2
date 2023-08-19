-- Forneça uma expressão SQL para buscar o nome do animal mais velho cadastrado. Caso exista mais de um com a mesma idade, mostrar apenas um deles. Resolva esta questão usando ordenação.

SELECT nomeanimal
FROM animais 
ORDER BY dtnascanimal ASC
LIMIT 1;