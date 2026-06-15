package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPagePOM
{
    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(name = "Password")
    private WebElement passwordField;

    @FindBy(id = "RememberMe")
    private WebElement rememberMeCheckBox;

    @FindBy(xpath = "//a[@href='/passwordrecovery']")
    private WebElement forgetPasswordLink;

    @FindBy(css = "[value='Log in']")
    private WebElement logInButton;

    public LogInPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getRememberMeCheckBox() {
        return rememberMeCheckBox;
    }

    public WebElement getForgetPasswordLink() {
        return forgetPasswordLink;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }
}
