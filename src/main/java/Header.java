import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор для кнопки "Личный кабинет"
    private By personalAccountButton = By.xpath("//nav/a[contains(@class, 'AppHeader_header__link__3D_hX')]");

    // Локатор для логотипа
    private By logo = By.xpath("//*[@id='root']/div/header/nav/div");

    // Локатор для кнопки "Конструктор"
    private By constructorButton = By.xpath("//a[@class='AppHeader_header__link__3D_hX' and @href='/']");

    public void clickPersonalAccount() {
        driver.findElement(personalAccountButton).click();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public void clickLogo() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        driver.findElement(logo).click();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    public void clickConstructor() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        WebElement element = driver.findElement(constructorButton);
        String classCurrentValue = element.getAttribute("class");
        Assert.assertEquals("Атрибут class не найден'.", "AppHeader_header__link__3D_hX", classCurrentValue);
    }
    public void clickPersonalAccountAuthorized() {
        driver.findElement(personalAccountButton).click();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/account/profile";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }




}
