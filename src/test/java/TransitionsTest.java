import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static edu.praktikum.driver.WebDriverCreator.createWebDriver;

public class TransitionsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = createWebDriver();
    }

    @Test
    @Step
    public void transitionPersonalAccount() {
        Header objHeader = new Header(driver);
        objHeader.clickPersonalAccount();
    }

    @Test
    @Step
    public void transitionLogo() {
        Header objHeader = new Header(driver);
        objHeader.clickLogo();
    }

    @Test
    @Step
    public void transitionConstructor() {
        Header objHeader = new Header(driver);
        objHeader.clickConstructor();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
