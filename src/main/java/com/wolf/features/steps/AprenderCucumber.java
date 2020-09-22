package com.wolf.features.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AprenderCucumber {

    @Given("^que criei o arquivo corretamente$")
    public void queCrieiOArquivoCorretamente() throws Throwable {

    }

    @When("^executa-lo$")
    public void executaLo() throws Throwable {

    }

    @Then("^a especificacao deve finalizar com sucesso$")
    public void aEspecificacaoDeveFinalizarComSucesso() throws Throwable {

    }

    private int contador;
    @Given("^que o valor do contador e (\\d+)$")
    public void queOValorDoContadorE(int arg1) throws Throwable {
        contador = arg1;
    }

    @When("^eu incrementar em (\\d+)$")
    public void euIncrementarEm(int arg1) throws Throwable {
        contador += arg1;
    }

    @Then("^o valor do contador sera (\\d+)$")
    public void oValorDoContadorSera(int arg1) throws Throwable {
        Assert.assertEquals(arg1,contador);
    }



}
