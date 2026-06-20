package testpackage;

import baseclasspackage.RegisterBaseClass;
import org.testng.annotations.Test;

public class RegisterUsingBaseClass extends RegisterBaseClass
{
    @Test
    public void openRegisterPage()
    {
        actions.clickOnElement(navBar.getRegisterLink());
    }

    @Test(dependsOnMethods = "openRegisterPage")
    public void doRegister()
    {
        register.selectGender(gender);
        actions.writeInInputField(register.getFirstNameField(),firstName );
        actions.writeInInputField(register.getLastNameField(),lastName);
        actions.writeInInputField(register.getEmailField(),email);
        actions.writeInInputField(register.getPasswordField(),password);
        actions.writeInInputField(register.getConfirmPasswordField(),confirmPassword);
        actions.clickOnElement(register.getRegisterButton());
    }
}
