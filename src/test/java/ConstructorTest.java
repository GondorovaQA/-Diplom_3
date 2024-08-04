import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static edu.praktikum.driver.WebDriverCreator.createWebDriver;

public class ConstructorTest {
    private static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = createWebDriver();
    }
    @Test
    @Step
    public void checkTabs() {
        driver.get(MAIN_URL);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkSaucesTabActivation();
        objMainPage.checkFillingsTabActivation();
        objMainPage.checkRollsTabActivation();
    }
    @After
    public void tearDown() {
        driver.close();
    }

}
