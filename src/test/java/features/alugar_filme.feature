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

  Scenario Outline: :  deve dar condições conforme tipo de aluguel
    Given um filme com estoque de 2 unidades
    And que o preco do aluguel seja R$ <preco>
    And que o tipo do aluguel seja <tipo>
    When alugar
    Then O preco do aluguel será R$ <valor>
    And a data de entrega será em <qtdDias> dias
    And a pontuacao sera de <pontuacao> pontos

    Examples:
      | preco | tipo      | valor | qtdDias | pontuacao |
      |  4    | extendido | 8     | 3       |  2        |
      |  4    | comum     | 4     | 1       |  1        |
