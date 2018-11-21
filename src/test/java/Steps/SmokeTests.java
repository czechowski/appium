package Steps;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("To jest epic")
@Feature("To jest feature")

public class SmokeTests {

    @Test (groups = {"smoke","regression"})
    @Story("This is smoke test")
    @Description("Opis testu")
    public void fakeSmokeTest(){

    }

    @Test (groups = ("regression"))
    @Story("This is smoke test")
    @Description("Opis testu")
    public void fakeRegressionTest(){

    }

}

