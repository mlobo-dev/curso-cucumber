package features.steps;

import com.wolf.model.Filme;
import com.wolf.model.NotaAluguel;
import com.wolf.services.AluguelService;
import com.wolf.utils.DateUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AluguelFilmesSteps {

    private Filme filme;
    private AluguelService aluguelService = new AluguelService();
    private NotaAluguel nota;
    private String tipoAluguel;

    @Given("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(int arg1) {
        filme = new Filme();
        filme.setEstoque(arg1);
    }

    @Given("^que o preco do aluguel seja R\\$ (\\d+)$")
    public void queOPrecoDoAluguelSejaR$(double arg1) {
        filme.setAluguel(arg1);
    }

    String erro = "";

    @When("^alugar$")
    public void alugar() {
        try {
            nota = aluguelService.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }

    }

    @Then("^O preco do aluguel será R\\$ (\\d+)$")
    public void oPrecoDoAluguelSeráR$(int arg1) {
        Assert.assertEquals(arg1, nota.getPreco(), 0);
    }

    @Then("^a data de entrega será no dia seguinte$")
    public void aDataDeEntregaSeráNoDiaSeguinte() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Calendar retorno = Calendar.getInstance();
        retorno.setTime(nota.getEntrega());
        Assert.assertEquals(calendar.get(Calendar.DAY_OF_MONTH), retorno.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(calendar.get(Calendar.MONTH), retorno.get(Calendar.MONTH));
        Assert.assertEquals(calendar.get(Calendar.YEAR), retorno.get(Calendar.YEAR));
    }

    @Then("^o estoque do filme será (\\d+) unidade$")
    public void oEstoqueDoFilmeSeráUnidade(int arg1) {
        Assert.assertEquals(arg1, filme.getEstoque());
    }

    @Then("^nao sera possivel alugar$")
    public void naoSeraPossivelAlugar() throws Throwable {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Given("^que o tipo do aluguel seja (.*)$")
    public void queOTipoDoAluguelSejaExtendido(String tipo) throws Throwable {
        tipoAluguel = tipo;
    }

    @Then("^a data de entrega será em (\\d+) dias?$")
    public void aDataDeEntregaSeráEmDias(int arg1) {
        Date dataEsperada = DateUtil.obterDataDiferencaDias(arg1);
        Date dataReal = nota.getEntrega();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Then("^a pontuacao sera de (\\d+) pontos$")
    public void aPontuacaoSeraDePontos(int arg1) throws Throwable {
        Assert.assertEquals(arg1,nota.getPontuacao());
    }


}
