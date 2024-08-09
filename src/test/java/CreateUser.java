import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.SecureRandom;

import static io.restassured.RestAssured.given;

public class CreateUser {
    protected WebDriver driver;
    protected String accessToken;

    @Before
    public void browserStart() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");

        accessToken = createUserAndGetToken();
    }

    private String createUserAndGetToken() {
        String randomName = generateRandomString(8);
        String randomEmail = generateRandomEmail(12);
        Response response = given()
                .baseUri("https://stellarburgers.nomoreparties.site")
                .basePath("/api/auth/register")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{ \"email\": \"" + randomEmail + "\", \"password\": \"Password1234\", \"name\": \"" + randomName + "\" }")
                .when()
                .post();

        response.then().statusCode(200);
        String accessToken = response.jsonPath().getString("accessToken");
        return accessToken;
    }

    private String generateRandomString(int totalLength) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(totalLength);

        for (int i = 0; i < totalLength; i++) {
            int value = random.nextInt(26);
            char character = (char) ('a' + value);
            sb.append(character);
        }

        return sb.toString();
    }

    private String generateRandomEmail(int lengthBeforeDomain) {
        String localPart = generateRandomString(lengthBeforeDomain);
        return localPart + "@gmail.com";
    }

    @After
    public void browserQuit() {
        driver.quit();
    }
}
