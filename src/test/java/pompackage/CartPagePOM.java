package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPagePOM
{
    @FindBy(xpath = "//table[@class='cart']")
    private WebElement productTable;

    public CartPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getProductTable()
    {
        return productTable;
    }
}
