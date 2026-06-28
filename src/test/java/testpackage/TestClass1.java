package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestClass1
{
    @Test(groups = "Integration")
    public void testMethod1()
    {
        Reporter.log("this is TestMethod 1 form testClass1",true);
    }

    @Test(groups = "System")
    public void testMethod2()
    {
        Reporter.log("this is TestMethod 2 form testClass1",true);
    }

    @Test(groups = "System")
    public void testMethod3()
    {
        Reporter.log("this is TestMethod 3 form testClass1",true);
    }

    @Test(groups = "Integration")
    public void testMethod4()
    {
        Reporter.log("this is TestMethod 4 form testClass1",true);
    }
}
