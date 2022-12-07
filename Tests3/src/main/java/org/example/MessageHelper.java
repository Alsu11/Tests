package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MessageHelper extends HelperBase {

    private Message message;

    public MessageHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void sendMessage(Message message) {
        driver.get("https://jut.su/pm/");
        driver.findElement(By.linkText("Отправить сообщение")).click();
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("DanisNaruto");
        driver.findElement(By.cssSelector(".tableform > tbody > tr:nth-child(1) > td:nth-child(2)")).click();
        driver.findElement(By.name("subj")).click();
        driver.findElement(By.name("subj")).sendKeys("test");
        driver.findElement(By.id("comments")).click();
        driver.findElement(By.id("comments")).sendKeys(message.getTextMessage());
        driver.findElement(By.name("add")).click();
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
