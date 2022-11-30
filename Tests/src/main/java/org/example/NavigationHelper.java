package org.example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.Dimension;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void openHomePage() {
        driver.get("https://jut.su/");
        driver.manage().window().setSize(new Dimension(1550, 838));
    }

}
