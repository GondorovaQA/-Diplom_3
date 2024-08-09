import io.qameta.allure.Step;
import org.junit.Test;

public class LoginTest extends CreateUser {
    @Test
    @Step
    public void loginMainTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.loginAccount();
        objMainPage.setLoginEmail();
        objMainPage.setLoginPassword();
        objMainPage.checkMainLogin();
    }

    @Test
    @Step
    public void loginPersonalAccountTest() {
        Header objHeader = new Header(driver);
        objHeader.clickPersonalAccount();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.setLoginEmail();
        objMainPage.setLoginPassword();

        objMainPage.checkMainLogin();

    }

    @Test
    @Step
    public void loginRegistration() {
        Header objHeader = new Header(driver);
        objHeader.clickPersonalAccount();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.submitRegistrationButton();
        objRegistrationPage.clickLoginLink();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.setLoginEmail();
        objMainPage.setLoginPassword();
        objMainPage.checkMainLogin();
    }

    @Test
    @Step
    public void loginRecoveryPassword() {
        Header objHeader = new Header(driver);
        objHeader.clickPersonalAccount();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.clickRecoveryPasswordLink();
        objRegistrationPage.clickLoginLink();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.setLoginEmail();
        objMainPage.setLoginPassword();
        objMainPage.checkMainLogin();
    }
}
