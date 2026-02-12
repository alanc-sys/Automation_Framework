package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);


    @Before
    public void setUp() throws IOException {
        logger.info("---Starting new test Scenario---");
        DriverManager.getInstance().getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        logger.info("---Ending test Scenario. Closing Browser---");
        DriverManager.getInstance().closeDriver();
    }
}
