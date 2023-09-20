## Projeto da Disciplina - Fase 1
O projeto deste semestre visa desenvolver aplicações sobre bancos de dados. O mesmo será constituído por duas fases. Na Fase 1 o foco estará em desenvolver uma aplicação para um banco de dados relacional. Já na Fase 2 a aplicação deverá ser adaptada para utilizar um banco de dados NoSQL. O projeto poderá ser desenvolvido em duplas ou individualmente. A seguir, instruções sobre a realização da Fase 1:

- Cada equipe deverá informar um domínio de informação ao qual a aplicação será desenvolvida (Exemplo: clínica veterinária, biblioteca, etc). NÃO PODERÃO HAVER REPETIÇÕES DE UM MESMO DOMÍNIO ENTRE EQUIPES. Ao escolher o seu, informe na planilha abaixo para que tal domínio seja atribuído a vc ou sua equipe. Prazo para me informar: 14/09
- A equipe deverá desenvolver o esquema conceitual e o esquema lógico relacional para seu respectivo domínio. O domínio de informação deverá ser bem explorado, de forma que a simplificação do mesmo será considerada como penalização da nota da equipe (caso hajam dúvidas, conversar com a professora). O esquema relacional deverá estar normalizado e estar no formato de um dicionário de dados (ver material de aula para saber o que é um dicionário de dados). 

- Um banco de dados referente ao esquema relacional apresentado deverá ser produzido. O mesmo deverá conter dados previamente inseridos.

- Uma aplicação deverá ser desenvolvida que faça uso e manipulação do banco de dados relacional. Tal aplicação não necessita apresentar uma interface gráfica, portanto, se a equipe preferir poderá usar a interface em modo texto (REST não será aceito como interface). Não será exigida uma linguagem de programação específica, entretanto, a solução exemplo e suporte da professora será apenas na linguagem Java. Esta aplicação deverá prover interfaces e respectivo funcionamento para as seguintes operações:

Operações CRUD para todas as tabelas de entidade do banco de dados (Exemplo de um CRUD: cadastro, recuperação (consulta), atualização (update) e remoção (delete) de Animais de uma clínica veterinária)
Operações de Processos de negócio para todas as tabelas associativas do banco de dados - são tabelas que relacionam mais de uma entidade (Exemplo: Efetuar consulta de um Animal da clínica - o que deve relacionar um veterinário, o animal, seu dono e contendo informações do que foi tratado na consulta como doença e medicamentos prescritos)
Mínimo de 3 Relatórios do sistema. Cada relatório deve envolver a associação de mais de uma tabela (Exemplo: Relatório dos animais atendidos em um dado período por um dado veterinário)
Na Fase 1 as equipes deverão entregar:

1) Um documento de texto contendo: (a) uma seção com uma introdução explicativa do domínio de informação escolhido, (b) o esquema conceitual e (c) o esquema lógico na forma de um dicionário de dados

2) Um repositório ou diretório na nuvem contendo: (a) arquivos de código-fonte da aplicação desenvolvida, (b) um arquivo de backup do banco de dados e (c) um arquivo de texto com instruções para a compilação e execução da aplicação. Forneça o link do repositório no documento de texto solicitado no item 1.

## Tecnologias Utilizadas - Backend
- Java
- Spring Boot
- MySQL (banco de dados relacional)
