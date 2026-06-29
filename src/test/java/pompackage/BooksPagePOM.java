package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BooksPagePOM
{
    @FindBy(xpath = "//div[@class='item-box']/descendant::a[text()='Computing and Internet']")
    private WebElement computingAndInternetBookLink;

    @FindBy(xpath = "//div[@class='item-box']/descendant::a[text()='Fiction']")
    private WebElement fictionBookLink;

    @FindBy(xpath = "//div[@class='product-item']")
    private List<WebElement> allBooksCard;

    public BooksPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getComputingAndInternetBookLink() {
        return computingAndInternetBookLink;
    }

    public WebElement getFictionBookLink() {
        return fictionBookLink;
    }

    public List<WebElement> getAllBooksCard()
    {
        return allBooksCard;
    }

    public void selectDesiredBook(String bookName)
    {
        for(WebElement book : allBooksCard)
        {
          String actualBook  = book.findElement(By.xpath("./descendant::h2/a")).getText();
          if (actualBook.equals(bookName))
          {
              book.click();
              break;
          }
        }
    }


}
