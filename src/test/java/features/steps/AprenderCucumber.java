package features.steps;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        Assert.assertEquals(arg1, contador);
    }


    Date entrega;

    @Given("^que a entrega e dia (.*)$")
    public void queAEntregaEDia(@Transform(DateConverter.class) Date data) throws Throwable {
        entrega = data;
    }

    @When("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
    public void aEntregaAtrasarEmDias(int quantidade, String tempo) throws Throwable {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(entrega);
        if (tempo.equals("dias")) {
            calendar.add(Calendar.DAY_OF_MONTH, quantidade);
        }
        if (tempo.equals("meses"))
            calendar.add(Calendar.MONTH, quantidade);
        entrega = calendar.getTime();
    }

    @Then("^a entrega sera efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeraEfetuadaEm(String data) throws Throwable {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }





}
