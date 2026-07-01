package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ComputerPagePOM
{
    @FindBy(xpath = "//div[@class='item-box']/descendant::h2/a")
    private List<WebElement> allComputerOption;


    public ComputerPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void selectDesiredComputerOption(String name)
    {
        for(WebElement option : allComputerOption)
        {
            if (option.getText().contains(name))
            {
                option.click();
                break;
            }
        }
    }

}
