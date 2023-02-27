package lecture13.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

// Test - successful login
// 0. Navigate to Home page
// 1. Navigate to Login page by clicking Login tab button
// 2. Validate that the url is correct
// 3. Validate that the 'Sign in' text is visible
// 4. Enter correct username
// 5. Enter correct password
// 6. Click sign in button
// 7. Validate that the url is correct ( Home page expected )
// 8. Validate that there is a Profile tab button visible
// 9. Validate that there is a New post tab button visible
// 10. Click Profile button
// 11. Validate that the correct username is displayed.
public class LoginTest {

    ChromeDriver driver;
    final String homepageUrl = "http://training.skillo-bg.com:4200/posts/all";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homepageUrl);
    }

    @Test
    public void testLogin() {
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
        usernameField.sendKeys("auto_user");

        System.out.println("5. Enter correct password");
        WebElement passwordField = driver.findElement(By.cssSelector("input[formcontrolname='password']"));
        passwordField.sendKeys("auto_pass");

        System.out.println("6. Click sign in button");
        WebElement signInButton = driver.findElement(By.cssSelector("#sign-in-button"));
        signInButton.click();

        System.out.println("7. Validate that the url is correct ( Home page expected )");
        wait.until(ExpectedConditions.urlToBe(homepageUrl));

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
        softAssert.assertEquals(usernameHeader.getText(), "auto_user", "Incorrect username!");

        softAssert.assertAll();

    }

    @AfterMethod
    public void cleanup() {
        driver.close();
    }
}
