package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

import java.io.IOException;

/**
 * Manages the execution lifecycle of each test scenario.
 * <p>
 * This class uses <b>Cucumber</b> annotations to define Setup and Teardown tasks
 * that run automatically before and after each Scenario.
 * </p>
 */

public class Hooks {

    @Before
    public void setUp() throws IOException {
        DriverManager.getInstance().getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        DriverManager.getInstance().closeDriver();
    }
}
