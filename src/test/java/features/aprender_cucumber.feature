@esse
Feature: feature teste

  Scenario: Scenario
    Given que criei o arquivo corretamente
    When executa-lo
    Then a especificacao deve finalizar com sucesso

  Scenario: Deve incrementar contador
    Given que o valor do contador e 15
    When  eu incrementar em 3
    Then  o valor do contador sera 18

  Scenario: Deve incrementar contador
    Given que o valor do contador e 16
    When  eu incrementar em 4
    Then  o valor do contador sera 20

  Scenario: Deve calcular atraso na entrega
    Given que a entrega e dia 05/04/2018
    When a entrega atrasar em 2 dias
    Then a entrega sera efetuada em 07/04/2018

  Scenario: Deve calcular atraso na entrega na china
    Given que a entrega e dia 05/04/2018
    When a entrega atrasar em 2 meses
    Then a entrega sera efetuada em 05/06/2018


