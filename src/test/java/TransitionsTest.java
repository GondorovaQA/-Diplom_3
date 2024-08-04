import edu.praktikum.driver.WebDriverCreator;
import io.qameta.allure.Step;
import org.junit.Test;

public class TransitionsTest extends WebDriverCreator {
    @Test
    @Step
    public void transitionPersonalAccount() {
        Header objHeader = new Header(createWebDriver());
        objHeader.clickPersonalAccount();
    }

    @Test
    @Step
    public void transitionLogo() {
        Header objHeader = new Header(createWebDriver());
        objHeader.clickLogo();
    }

    @Test
    @Step
    public void transitionConstructor() {
        Header objHeader = new Header(createWebDriver());
        objHeader.clickConstructor();
    }
}
