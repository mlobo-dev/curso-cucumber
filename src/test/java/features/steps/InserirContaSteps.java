package features.steps;

import cucumber.api.PendingException;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContaSteps {

    private WebDriver driver;

    @Dado("^que estou acessando a aplicação$")
    public void queEstouAcessandoAAplicação() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com/");
    }

    @Quando("^informo o usuário \"([^\"]*)\"$")
    public void informoOUsuário(String usuario) {
        driver.findElement(By.id("email")).sendKeys(usuario);
    }

    @Quando("^a senha \"([^\"]*)\"$")
    public void aSenha(String senha) {
        driver.findElement(By.name("senha")).sendKeys(senha);
    }

    @Quando("^seleciono entrar$")
    public void selecionoEntrar() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("^visualizo a página inicial$")
    public void visualizoAPáginaInicial() throws Throwable {
        String text = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, abc!", text);

    }

    @Quando("^seleciono Contas$")
    public void selecionoContas() throws Throwable {
        driver.findElement(By.linkText("Contas")).click();
    }

    @Quando("^seleciono Adicionar$")
    public void selecionoAdicionar() throws Throwable {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("^informo a conta \"([^\"]*)\"$")
    public void informoAConta(String nome) throws Throwable {
        driver.findElement(By.name("nome")).sendKeys(nome);
    }

    @Quando("^seleciono Salvar$")
    public void selecionoSalvar() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("^a conta é inserida com sucesso$")
    public void aContaÉInseridaComSucesso() throws Throwable {
        String text = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", text);
    }
}
