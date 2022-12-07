package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private LoginHelper loginHelper;
    private MessageHelper messageHelper;
    private NavigationHelper navigationHelper;

    public ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "/home/user/Рабочий стол/chromedriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        loginHelper = new LoginHelper(this);
        messageHelper = new MessageHelper(this);
        navigationHelper = new NavigationHelper(this);
    }

    protected void stop() {
        driver.quit();
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public MessageHelper getMessageHelper() {
        return messageHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
