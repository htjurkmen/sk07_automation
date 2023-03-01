package lecture14.exercises.regressionSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Test scenario - Successful registration
// 1. Navigate to Login page
// 2. Click on 'Register'
// 3. Validate the url has changed to /register
// 4. Validate that the Sign up header is shown
// 5. Enter username
// 6. Enter email
// 7. Enter password
// 8. Confirm password
// 9. Click sign in button
// 10. Validate that a pop-up appears indicating a successful registration
// 11. Validate that the user is redirected to home page


public class NewUserTest {

    ChromeDriver driver;

    final String baseUrl = "http://training.skillo-bg.com:4200";
    final String registerUrl = baseUrl + "/users/register";
    final String homeUrl = baseUrl + "/posts/all";

    @BeforeMethod
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(homeUrl);
    }

    @Parameters({"username", "email", "password"})
    @Test
    public void registerUser(String username, String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("1. Navigate to Login page");
        clickElement(By.id("nav-link-login"), 5, 100);

        System.out.println("2. Click on 'Register'");
        clickElement(By.linkText("Register"), 5);

        System.out.println("3. Validate the url has changed to /register");
        wait.until(ExpectedConditions.urlToBe(registerUrl));

        System.out.println("4. Validate that the Sign up header is shown");
        WebElement signUpHeader = driver.findElement(By.xpath("//app-register//h4[text()='Sign up']"));
        wait.until(ExpectedConditions.visibilityOf(signUpHeader));

        System.out.println("5. Enter username");
        WebElement usernameField = driver.findElement(By.name("username"));
        enterTextField(usernameField, username);

        System.out.println("6. Enter email");
        WebElement emailField = driver.findElement(By.cssSelector("input[formcontrolname='email']"));
        enterTextField(emailField, email);

        System.out.println("7. Enter password");
        WebElement passField = driver.findElement(By.id("defaultRegisterFormPassword"));
        enterTextField(passField, password);

        System.out.println("8. Confirm password");
        WebElement confirmPassField = driver.findElement(By.name("verify-password"));
        enterTextField(confirmPassField, password);

        System.out.println("9. Click sign in button");
        clickElement(By.id("sign-in-button"), 3);

        System.out.println("10. Validate that a pop-up appears indicating a successful registration");
        WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-message")));
        String toastMsgText = toastMsg.getText().trim();
        Assert.assertEquals(toastMsgText, "Successful register!", "Registration was not successful");

        System.out.println("11. Validate that the user is redirected to home page");
        wait.until(ExpectedConditions.urlToBe(homeUrl));
    }

    @Parameters({"username", "password"})
    @Test(dependsOnMethods = "registerUser")
    public void testLogin(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverWait smallWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println("1. Navigate to Login page by clicking Login tab button");
        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        loginButton.click();

        System.out.println("2. Validate that the url is correct");
        String expectedUrl = "http://training.skillo-bg.com:4200/users/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        System.out.println("3. Validate that the 'Sign in' text is visible");
        WebElement signInElement = driver.findElement(By.xpath("//p[text()='Sign in']"));
        Assert.assertTrue(signInElement.isDisplayed(), "Sign in form is not visible");

        System.out.println("4. Enter correct username");
        WebElement usernameField = driver.findElement(By.name("usernameOrEmail"));
        usernameField.sendKeys(username);

        System.out.println("5. Enter correct password");
        WebElement passwordField = driver.findElement(By.cssSelector("input[formcontrolname='password']"));
        passwordField.sendKeys(password);

        System.out.println("6. Click sign in button");
        WebElement signInButton = driver.findElement(By.cssSelector("#sign-in-button"));
        signInButton.click();

        System.out.println("7. Validate that the url is correct ( Home page expected )");
        wait.until(ExpectedConditions.urlToBe(homeUrl));

        System.out.println("8. Validate that there is a Profile tab button visible");
        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        //       Assert.assertTrue(profileLink.isDisplayed(), "Profile link is not visible");
        smallWait.until(ExpectedConditions.visibilityOf(profileLink));

        System.out.println("9. Validate that there is a New post tab button visible");
        WebElement newPostLink = driver.findElement(By.linkText("New post"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(newPostLink.isDisplayed(), "New post link is not visible");

        System.out.println("10. Click Profile button");
        profileLink.click();

        System.out.println("11. Validate that the correct username is displayed.");
        WebElement usernameHeader = driver.findElement(By.cssSelector("app-profile-section h2"));
        softAssert.assertEquals(usernameHeader.getText(), username, "Incorrect username!");

        softAssert.assertAll();

    }

    /**
     * Waits for WebElement to become clickable and clicks it
     *
     * @param locator
     * @param timeoutSec
     * @return
     */
    private WebElement clickElement(By locator, int timeoutSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        return element;
    }

    /**
     * Click element using a specified polling timeout ( FluentWait )
     *
     * @param locator
     * @param totalTimeoutSec
     * @param retryTimeoutMs
     * @return
     */
    private WebElement clickElement(By locator, int totalTimeoutSec, int retryTimeoutMs) {
        FluentWait<ChromeDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(totalTimeoutSec))
                .pollingEvery(Duration.ofMillis(retryTimeoutMs))
                .ignoring(TimeoutException.class);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        return element;
    }

    /**
     * Enters a given text in an input field
     *
     * @param element
     * @param text
     */
    private void enterTextField(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
        Boolean isValid = element.getAttribute("class").contains("is-valid");
        Assert.assertTrue(isValid, "The field is invalid!");

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
