package org.example.helpers;

import org.example.ApplicationManager;
import org.example.models.Account;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    private Account account;

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(Account account) {
        this.account = account;
        driver.findElement(By.cssSelector(".login_btn")).click();
        driver.findElement(By.id("login_input1")).click();
        driver.findElement(By.id("login_input1")).sendKeys(account.getUserName());
        driver.findElement(By.id("login_input2")).click();
        driver.findElement(By.id("login_input2")).sendKeys(account.getPassword());
        driver.findElement(By.id("login_submit")).click();
    }
    public Boolean isLogged() {
        return driver.findElement(By.id("topLoginPanel")).isEnabled();
    }

}
