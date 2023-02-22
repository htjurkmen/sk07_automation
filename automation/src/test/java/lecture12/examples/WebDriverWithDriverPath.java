package lecture12.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverWithDriverPath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "automation/src/test/resources/drivers/chromedriver.exe");
        // WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://training.skillo-bg.com:4300/posts/all");
        driver.manage().window().maximize();
        driver.close();
    }
}
