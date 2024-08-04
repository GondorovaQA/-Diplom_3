import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static edu.praktikum.driver.WebDriverCreator.createWebDriver;

public class RegistrationTest  {

    private static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";


    private WebDriver driver;
    @Before
    public void setUp() {
        driver = createWebDriver();
    }

    @Test
    @Step
    public void successfulRegistration() {
        driver.get(MAIN_URL);
        Header objHeader = new Header(createWebDriver());
        objHeader.clickPersonalAccount();
        RegistrationPage objRegistrationPage = new RegistrationPage(createWebDriver());
        objRegistrationPage.submitRegistrationButton();
        objRegistrationPage.setNameInput();
        objRegistrationPage.setEmailInput();
        objRegistrationPage.setPasswordInput();
        objRegistrationPage.submitRegistrationForm();
        objRegistrationPage.loginActivity();

    }
    @Test
    @Step
    public void errorPassword() {
        driver.get(MAIN_URL);
        Header objHeader = new Header(createWebDriver());
        objHeader.clickPersonalAccount();
        RegistrationPage objRegistrationPage = new RegistrationPage(createWebDriver());
        objRegistrationPage.submitRegistrationButton();
        objRegistrationPage.setNameInput();
        objRegistrationPage.setEmailInput();
        objRegistrationPage.setPasswordInputError();
        objRegistrationPage.submitRegistrationForm();
        objRegistrationPage.findMessageError();
    }
    @After
    public void tearDown() {
        driver.close();
    }
}
