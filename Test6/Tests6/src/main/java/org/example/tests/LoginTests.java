package org.example.tests;

import org.example.models.Account;
import org.junit.Assert;
import org.junit.Test;

import static org.example.utils.Settings.*;

public class LoginTests extends TestBase {

    @Test
    public void loginWithValidData() {
        applicationManager.getLoginHelper().logout();
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getLoginHelper().login(new Account(getLogin(), getPassword()));
        Assert.assertTrue(applicationManager.getLoginHelper().isLogged());
    }

    @Test
    public void loginWithInvalidData() {
        applicationManager.getLoginHelper().logout();
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getLoginHelper().login(new Account("Posh", "danis"));
        Assert.assertFalse(applicationManager.getLoginHelper().isLogged());
    }
}
