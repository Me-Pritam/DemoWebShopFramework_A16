package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstTestNGExecution
{
    @Test(priority = 1)
    public void logIn()
    {
        Reporter.log("LogIn is Performed",true);
    }

    @Test(priority = 2)
    public void searchFriend()
    {
        Reporter.log("Desired Friend is searched",true);
    }

    @Test(priority = 3)
    public void sendRequest()
    {
        Reporter.log("Friend Request is sent",true);
    }

    @Test(priority = 4)
    public void notification()
    {
        Reporter.log("Notification is received",true);
    }

    @Test(priority = 5)
    public void logOut()
    {
        Reporter.log("Log out is done",true);
    }
}
