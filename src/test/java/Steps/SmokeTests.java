package Steps;

import org.testng.annotations.Test;

public class SmokeTests {

    @Test (groups = {"smoke","regression"})
    public void fakeSmokeTest(){

    }

    @Test (groups = ("regression"))
    public void fakeRegressionTest(){

    }

}

