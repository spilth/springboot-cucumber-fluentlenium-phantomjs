package foo.features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"foo", "cucumber.api.spring"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class RunCucumberTest {
}
