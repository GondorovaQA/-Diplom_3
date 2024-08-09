import io.qameta.allure.Step;
import org.junit.Test;

public class LogOutTest extends CreateUser {
    @Test
    @Step
    public void logOut() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.loginAccount();
        objMainPage.setLoginEmail();
        objMainPage.setLoginPassword();
        objMainPage.checkMainLogin();
        Header objHeader = new Header(driver);
        objHeader.clickPersonalAccountAuthorized();
        PersonalAccountPage objPersonalAccountpage = new PersonalAccountPage(driver);
        objPersonalAccountpage.checkLogOut();
    }
}
