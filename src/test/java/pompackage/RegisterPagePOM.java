package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPagePOM
{
    @FindBy(xpath = "//div[@class='gender']/child::label")
    private List<WebElement> allGenders;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(name = "LastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@id='register-button']")
    private WebElement registerButton;

    public RegisterPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public void selectGender(String gender)
    {

        for(WebElement element : allGenders)
        {
            if (element.getText().equalsIgnoreCase(gender))
            {
                element.click();
                break;
            }
        }

    }
}
