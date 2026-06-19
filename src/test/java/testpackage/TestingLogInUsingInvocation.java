package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pompackage.LogInPagePOM;
import utilitypackage.ActionsUtil;

import java.time.Duration;

public class TestingLogInUsingInvocation
{


    @Test(invocationCount = 5)
    public void doLogIn()
    {
        int i=1;

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://demowebshop.tricentis.com/login");

            LogInPagePOM logIn = new LogInPagePOM(driver);

            ActionsUtil action = new ActionsUtil(driver);

            action.writeInInputField(logIn.getEmailField(),"themail"+i+"@gmail.com");



            action.writeInInputField(logIn.getPasswordField(),"Password@1234");

            action.clickOnElement(logIn.getLogInButton());

            driver.close();
    }
}
