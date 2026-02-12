package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

import java.io.IOException;

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
