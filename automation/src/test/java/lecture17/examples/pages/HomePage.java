package lecture17.examples.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final String URL = "http://training.skillo-bg.com:4200/posts/all";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.get(URL);
    }

    public void verifyUrl() {
        verifyUrl(URL);
    }
}
