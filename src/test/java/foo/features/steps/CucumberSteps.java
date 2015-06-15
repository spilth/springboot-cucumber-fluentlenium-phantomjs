package foo.features.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CucumberSteps extends FluentTest {
    private WebDriver driver;

    @Before
    public void before() {
        setupFluentlenium();
    }

    @After
    public void after(){
        teardownFluentlenium();
    }

    @When("^I visit the homepage$")
    public void i_visit_the_homepage() throws Throwable {
        goTo("http://google.com");
    }

    @Then("^I should see the welcome page$")
    public void i_should_see_the_welcome_page() throws Throwable {
        assertThat(find("body").getText(), containsString("Install Google Chrome"));
    }

    @Override
    public WebDriver getDefaultDriver() {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            driver = new PhantomJSDriver(capabilities);
            driver.manage().window().setSize(new Dimension(1280, 1920));
        }

        return driver;
    }

    protected void setupFluentlenium() {
        this.initFluent(getDefaultDriver());
        this.initTest();
    }

    protected void teardownFluentlenium() {
        this.quit();
    }
}
