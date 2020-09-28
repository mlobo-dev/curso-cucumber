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
        tags = {"~@ignore","@unitarios"},
        glue = "features/steps",
        features = "src/test/java/features",
        dryRun = false
)

public class RunnerTest {



}
