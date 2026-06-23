package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPagePOM
{
    @FindBy(xpath = "//div[@class='item-box']/descendant::a[text()='Computing and Internet']")
    private WebElement computingAndInternetBookLink;

    public BooksPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getComputingAndInternetBookLink() {
        return computingAndInternetBookLink;
    }
}
