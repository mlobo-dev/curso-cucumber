import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        plugin = "pretty",
//        monochrome = true,
        tags = {"@esse"},
        glue = "features/steps",
        features = "src/test/java/features"
)

public class Runner {

}
