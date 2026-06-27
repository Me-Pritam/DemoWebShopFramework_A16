package listenerspackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.lang.reflect.Field;

public class AddToCartButton_Listener implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result)
    {
        Reporter.log("The "+result.getMethod().getMethodName()+" method is started executing",true);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        Reporter.log("The "+result.getMethod().getMethodName()+" method is Passed",true);
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        Reporter.log("The "+result.getMethod().getMethodName()+" method is Skipped",true);
    }

    @Override
    public void onStart(ITestContext context)
    {
        Reporter.log("The "+context.getName()+" Context is started executing",true);
    }

    @Override
    public void onFinish(ITestContext context)
    {
        Reporter.log("The "+context.getName()+" Context is finished executing",true);
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        try
        {
            Object testInstance = result.getInstance();

            Field field = testInstance.getClass().getField("driver");

            field.setAccessible(true);

            WebDriver driver = (WebDriver) field.get(testInstance);

            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File tempFile = screenshot.getScreenshotAs(OutputType.FILE);
            File srcFile = new File("./FailedScreenshots/"+result.getMethod().getMethodName()+"SS.png");

            FileHandler.copy(tempFile,srcFile);


        } catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
