package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setup() throws Exception {
    }
    @After
    public void tearDown() {
        System.out.println("after");
    }
}
