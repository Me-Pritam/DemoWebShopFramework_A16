package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestClass2
{
    @Test(groups = "Integration")
    public void testMethod5()
    {
        Reporter.log("this is TestMethod 5 form testClass2",true);
    }

    @Test(groups = "System")
    public void testMethod6()
    {
        Reporter.log("this is TestMethod 6 form testClass2",true);
    }

    @Test
    public void testMethod7()
    {
        Reporter.log("this is TestMethod 7 form testClass2",true);
    }

    @Test(groups = {"Integration","System"})
    public void testMethod8() {
        Reporter.log("this is TestMethod 8 form testClass2", true);
    }
}
