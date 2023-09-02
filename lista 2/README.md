Considere o seguinte esquema de BD relacional para o domínio de passagens rodoviárias:

Empresas

(#codEmpresa, nome, autorização)

Trechos

(#codTrecho, &codEmpresa, cidadeOrigem, cidadeDestino)

Passageiros

(#codPass, nome, idade, [&passResponsavel])

Bilhetes

(#codReserva, dtEmissao, &codTrecho, &codPass, preço, poltrona)

 

Observações sobre este esquema relacional:

-          A chave primária de uma relação é definida pelo conjunto de atributos pré-fixados com #. Todos os atributos que fazem parte das chaves primárias são inteiros positivos;

-          Atributos pré-fixados com & são chaves estrangeiras, e referem-se a chaves primárias de outras tabelas;

-          Atributos entre colchetes correspondem a atributos opcionais;

-          Relação Empresas: registra o código das Empresas de viação, seus respectivos nomes e números de autorizações;

-          Relação Trechos: registra as várias possibilidades de trechos oferecidos por uma empresa. O atributo codEmpresa define uma chave estrangeira para a relação Empresas;

-          Relação Passageiros: registra os dados dos passageiros. O passageiro pode estar associado a um outro passageiro que representa o seu responsável. Neste caso, o atributo passResponsavel representa uma chave estrangeira para a relação Passageiros;

-          Relação Bilhetes: registra os bilhetes de passagem rodoviária adquiridos pelos passageiros. Além do código da reserva e sua data, a relação define uma chave estrangeira para a relação Trechos através do atributo codTrecho e outra chave estrangeira para a relação Passageiros através de codPass. O preço pago pelo bilhete bem como o número da poltrona comprada são armazenados pelos atributos preço e poltrona, respectivamente.