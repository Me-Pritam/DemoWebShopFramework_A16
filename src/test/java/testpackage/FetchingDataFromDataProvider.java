package testpackage;

import dataproviderpackage.DummyDataProviderClass;
import dataproviderpackage.LogInCredentialsDataProvider;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FetchingDataFromDataProvider {

    @Test(dataProviderClass = LogInCredentialsDataProvider.class,dataProvider = "userCredentials")
    public void testMethod(String userName, String password)
    {
        Reporter.log("User --> "+userName+" Password --> "+password,true);
    }
}
