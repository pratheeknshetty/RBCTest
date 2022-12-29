package RBCTest.Hipolabs.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
        "html:target/cucumber.html"},
        monochrome = true,
        publish = true,
        features = "src/test/resources/features",
        glue = "RBCTest.Hipolabs",
        tags = "@SearchService"

)
public class TestRunner {
}
