import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор для кнопки "Войти в аккаунт"
    private By loginAccountButton = By.xpath("//button[contains(text(), 'Войти в аккаунт')]");

    // Локатор для вкладки "Соусы"
    private By saucesTab = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Соусы']]");
    // Локатор для активной вкладки "Соусы"

    private By activeSaucesTab = By.xpath("//div[contains(@class, 'tab_tab__1SPyG tab_tab_type_current__2BEPc') and .//span[text()='Соусы']]");

    // Локатор для вкладки "Начинки"
    private By fillings = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[3]");
    // Локатор для активной вкладки "Начинки"

    private By activeFillings = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Начинки']");
    // Локатор для вкладки "Булки"

    private By rolls = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[1]");
    // Локатор для активной вкладки "Булки"

    private By activityRolls = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Булки']");

    // Локатор для инпута "Email"
    private By loginEmail = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");

    // Локатор для инпута "Пароль"
    private By loginPassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");

    // Локатор для кнопки "Войти" в личном кабинете
    private By personalAccountLoginButton = By.xpath("//*[@id='root']/div/main/div/form/button");


    public void loginAccount() {
        driver.findElement(loginAccountButton).click();
    }

    public void checkSaucesTabActivation() {
        driver.findElement(saucesTab).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(activeSaucesTab,"Соусы"));
    }

    public void checkFillingsTabActivation() {
        driver.findElement(fillings).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(activeFillings,"Начинки"));
    }

    public void checkRollsTabActivation() {
        driver.findElement(rolls).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(activityRolls,"Булки"));
    }

    public void setLoginEmail() {
        driver.findElement(loginEmail).sendKeys("newuser15@yandex.com");
    }

    public void setLoginPassword() {
        driver.findElement(loginPassword).sendKeys("Password1234");
    }

    public void checkMainLogin() {
        driver.findElement(personalAccountLoginButton).click();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/"; // Ожидаемый URL - главная страница
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание до 5 секунд
        wait.until(ExpectedConditions.urlToBe(expectedUrl)); // Ожидание того, что URL станет ожидаемым
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl); // Проверка, что текущий URL соответствует ожидаемому
    }


}
