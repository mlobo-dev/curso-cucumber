import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        plugin = "pretty",
        monochrome = true,
        glue = "com.wolf.features.steps",
        features = "/home/mlobodev/Área de Trabalho/fundamentos/src/main/java/com/wolf/features",
        strict = true
)

public class Runner {

}
