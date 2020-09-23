package features.steps;

import com.wolf.model.Filme;
import com.wolf.model.NotaAluguel;
import com.wolf.services.AluguelService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Calendar;


public class AluguelFilmesSteps {

    private Filme filme;
    private AluguelService aluguelService = new AluguelService();
    private NotaAluguel nota;

    @Given("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(int arg1) {
        filme = new Filme();
        filme.setEstoque(arg1);
    }

    @Given("^que o preco do aluguel seja R\\$ (\\d+)$")
    public void queOPrecoDoAluguelSejaR$(double arg1) {
        filme.setAluguel(arg1);
    }

    @When("^alugar$")
    public void alugar() {
        nota = aluguelService.alugar(filme);
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

}
