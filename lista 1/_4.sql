-- Forneça uma expressão SQL para buscar o código e nome dos animais que são irmãos por parte de pai e mãe do animal que se chama Salti.

SELECT a.codanimal, a.nomeanimal

FROM animais a

WHERE (codanimal <> 9 AND codanimalpai = 5 AND codanimalmae = 6); 