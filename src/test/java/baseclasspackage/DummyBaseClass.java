package baseclasspackage;

import org.testng.Reporter;
import org.testng.annotations.*;

public class DummyBaseClass
{
    @BeforeSuite
    public void beforeSuite()
    {
        Reporter.log("It is a Before Suite",true);
    }

    @BeforeTest
    public void beforeTest()
    {
        Reporter.log("It is a Before Test",true);
    }

    @BeforeClass
    public void beforeClass()
    {
        Reporter.log("It is a Before Class",true);
    }

    @BeforeMethod
    public void beforeMethod()
    {
        Reporter.log("It is a Before Method",true);
    }

    @AfterMethod
    public void afterMethod()
    {
        Reporter.log("It is a After Method",true);
    }

    @AfterClass
    public void afterclass()
    {
        Reporter.log("It is a After Class",true);
    }

    @AfterTest
    public void afterTest()
    {
        Reporter.log("It is a After Test",true);
    }

    @AfterSuite
    public void afterSuite()
    {
        Reporter.log("It is a After Suite",true);
    }

}
