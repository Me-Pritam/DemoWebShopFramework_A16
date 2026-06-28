package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPagePOM
{
    @FindBy(xpath = "//input[contains(@id,'add-to-cart-button')]")
    private WebElement addToCartButton;

    public ProductPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getAddToCartButton()
    {
        return addToCartButton;
    }
}
