import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty","html:target/report-html","json:target/report-json"},
//        monochrome = true,
        tags = {"~@ignore"},
        glue = "features/steps",
        features = "src/test/java/features/inserir_conta.feature",
        dryRun = false
)

public class RunnerTest {

}
