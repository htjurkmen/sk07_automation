package lecture17.examples.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class NewPostPage extends BasePage {

    private final String URL = "http://training.skillo-bg.com:4200/posts/create";

    @FindBy(css = ".image-preview")
    WebElement imagePreview;

    @FindBy(css = "input.input-lg")
    WebElement fileNameField;

    @FindBy(name = "caption")
    WebElement captionInput;

    @FindBy(id = "create-post")
    WebElement submitBtn;

    @FindBy(css = "input.file[type='file']")
    WebElement fileUploadInput;

    public NewPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUrl() {
        verifyUrl(URL);
    }

    public void uploadImage(File file) {
        fileUploadInput.sendKeys(file.getAbsolutePath());
    }

    public void waitForImageToShow() {
        smallWait.until(ExpectedConditions.visibilityOf(imagePreview));
    }

    public String getImageFilename() {
        smallWait.until(ExpectedConditions.visibilityOf(fileNameField));
        return fileNameField.getAttribute("placeholder");
    }

    public void populateCaption(String captionText) {
        enterText(captionInput, captionText);
    }

    public void submitPost() {
        clickElement(submitBtn);
    }

}
