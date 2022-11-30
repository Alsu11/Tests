package org.example.tests;

import org.example.ApplicationManager;
import org.example.models.Account;
import org.junit.Assert;
import org.junit.Before;

public class AuthBase extends TestBase {
    @Before
    public void setUp() {
        applicationManager.getNavigationHelper().openHomePage();
        applicationManager.getLoginHelper().login(new Account("PoshKamil", "danisdanis"));
        Assert.assertTrue(applicationManager.getLoginHelper().isLogged());
    }
}
