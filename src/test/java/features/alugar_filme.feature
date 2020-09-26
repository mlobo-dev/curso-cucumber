
Feature: Alugar filme

  Como um usuário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

Scenario: Deve alugar um filme com sucesso
  Given um filme com estoque de 2 unidades
  And que o preco do aluguel seja R$ 3
  When alugar
  Then O preco do aluguel será R$ 3
  And a data de entrega será no dia seguinte
  And o estoque do filme será 1 unidade

Scenario: Não deve alugar filme sem estoque
  Given um filme com estoque de 0 unidades
  When alugar
  Then nao sera possivel alugar
  And o estoque do filme será 0 unidade

Scenario:  Deve dar condições especiais para categoria extendida
  Given um filme com estoque de 2 unidades
  And que o preco do aluguel seja R$ 4
  And que o tipo do aluguel seja extendido
  When alugar
  Then O preco do aluguel será R$ 8
  And a data de entrega será em 3 dias
  And a pontuacao sera de 2 pontos

Scenario:  Deve dar condições  para categoria comum
  Given um filme com estoque de 2 unidades
  And que o preco do aluguel seja R$ 4
  And que o tipo do aluguel seja comum
  When alugar
  Then O preco do aluguel será R$ 4
  And a data de entrega será em 1 dias
  And a pontuacao sera de 1 pontos