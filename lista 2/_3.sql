-- Elabore uma consulta que mostre o nome e idade de todos os passageiros que tem como responsável o 
-- passageiro com nome “Rui Hachy”. Caso estes passageiros possuam bilhetes, mostrar também o código da reserva dos respectivos bilhetes.

SELECT p.nome, p.idade, b.codReserva FROM passageiros p
JOIN passageiros r ON p.passResponsavel = r.codPass
JOIN bilhetes b ON p.codPass = b.codPass
WHERE r.nome = 'Rui Hachy';
