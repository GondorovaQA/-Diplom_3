import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Random;

public class RegistrationPage  {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }



    private By registrationButton = By.xpath("//*[contains(@class, 'Auth_link__1fOlj') and contains(text(), 'Зарегистрироваться')]");

    // Локатор для инпута "Имя"
    private By nameInput = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]/div/div/input");

    // Локатор для инпута "Email"
    private By emailInput = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]/div/div/input");

    // Локатор для инпута "Пароль"
    private By passwordInput = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/fieldset[3]/div/div/input");

    private By submitRegistrationButton = By.xpath("//form/button");

    private By succsesfullRegistration = By.xpath("//main/div/h2");

    private By messageError = By.xpath("//p[@class='input__error text_type_main-default' and contains(text(), 'Некорректный пароль')]");

    private By loginLink = By.xpath("//*[@id='root']/div/main/div/div/p/a");

    private By recoveryPasswordLink = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");


    private String generateRandomString(int totalLength, boolean isEmail) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(totalLength);

        for (int i = 0; i < totalLength; i++) {
            int value = random.nextInt(26);
            char character = (char) ('a' + value);
            sb.append(character);
        }

        if (isEmail) {
            sb.insert(totalLength - 4, "@gmail.com");
        }

        return sb.toString();
    }

    public void submitRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void setNameInput() {
        String randomName = generateRandomString(8, false); // Генерация случайного имени длиной 8 символов
        driver.findElement(nameInput).sendKeys(randomName);
    }

    public void setEmailInput() {
        String randomEmail = generateRandomString(12, true); // Генерация адреса электронной почты длиной 12 символов
        driver.findElement(emailInput).sendKeys(randomEmail);
    }

    public void setPasswordInput() {
        String randomPassword = generateRandomString(8, false); // Генерация случайного пароля длиной 8 символов
        driver.findElement(passwordInput).sendKeys(randomPassword);
    }

    public void submitRegistrationForm() {
        driver.findElement(submitRegistrationButton).click();
    }

    public void loginActivity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By elem_dynamic = succsesfullRegistration;
        wait.until(ExpectedConditions.presenceOfElementLocated(elem_dynamic));
    }

    public void setPasswordInputError() {
        driver.findElement(passwordInput).sendKeys("12345");
    }

    public void findMessageError() {
        driver.findElement(messageError);
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void clickRecoveryPasswordLink() {
        driver.findElement(recoveryPasswordLink).click();
    }



    }

