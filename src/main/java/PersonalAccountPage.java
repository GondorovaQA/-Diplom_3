import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    private WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор дял кнопки "Выход"
    private By logOutButton = By.xpath("//*[@id='root']/div/main/div/nav/ul/li[3]/button");

    public void checkLogOut() {
        driver.findElement(logOutButton).click();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

}
