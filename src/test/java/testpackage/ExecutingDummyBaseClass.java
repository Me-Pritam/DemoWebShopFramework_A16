package testpackage;

import baseclasspackage.DummyBaseClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExecutingDummyBaseClass extends DummyBaseClass
{
    @Test
    public void testMethod()
    {
        Reporter.log("It is a Test Method",true);

    }
}
