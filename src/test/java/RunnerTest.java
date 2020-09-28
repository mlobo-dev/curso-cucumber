import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/report-html", "json:target/report-json"},
//        monochrome = true,
        tags = {"~@ignore"},
        glue = "features/steps",
        features = "src/test/java/features/inserir_conta.feature",
        dryRun = false
)

public class RunnerTest {

    @BeforeClass
    public static void reset() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com/");
        driver.findElement(By.id("email")).sendKeys("abc@mail.com");
        driver.findElement(By.name("senha")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }

}
