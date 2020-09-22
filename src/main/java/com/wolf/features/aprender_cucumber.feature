Feature: feature teste

  Scenario: cenário
    Given que criei o arquivo corretamente
    When executa-lo
    Then a especificacao deve finalizar com sucesso

  Scenario: Deve incrementar contador
    Given que o valor do contador e 15
    When  eu incrementar em 3
    Then  o valor do contador sera 18

