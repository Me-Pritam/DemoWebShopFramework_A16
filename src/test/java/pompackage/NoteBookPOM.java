package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NoteBookPOM
{
    @FindBy(xpath = "//div[@class='item-box']/descendant::h2/a")
    private WebElement laptopLink;

    public NoteBookPOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getLaptopLink() {
        return laptopLink;
    }
}
