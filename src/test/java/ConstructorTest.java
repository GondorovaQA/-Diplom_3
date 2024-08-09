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
        driver.get(MAIN_URL);
    }

    @Test
    @Step("Проверка активации вкладки Соусы")
    public void checkSaucesTabActivation() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkSaucesTabActivation();
    }

    @Test
    @Step("Проверка активации вкладки Начинки")
    public void checkFillingsTabActivation() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkFillingsTabActivation();
    }

    @Test
    @Step("Проверка активации вкладки Булки")
    public void checkRollsTabActivation() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkSaucesTabActivation();
        objMainPage.checkRollsTabActivation();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
