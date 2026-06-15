package utilitypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil
{
    Actions actions;
    WebDriver driver;

    public ActionsUtil(WebDriver driver)
    {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void clickOnElement(WebElement element)
    {
        actions.click(element).perform();
    }

    public void writeInInputField(WebElement element,String data)
    {
        actions.sendKeys(element,data).perform();
    }

    public void moveMouseToElement(WebElement element)
    {
        actions.moveToElement(element).perform();
    }
}
