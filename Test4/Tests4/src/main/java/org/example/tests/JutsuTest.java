package org.example.tests;// Generated by Selenium IDE

import org.example.models.Account;
import org.example.models.Message;
import org.junit.Assert;
import org.junit.Test;

public class JutsuTest extends TestBase {

  @Test
  public void jutsuTestLogin() {
    applicationManager.getNavigationHelper().openHomePage();
    applicationManager.getLoginHelper().login(new Account("PoshKamil", "danisdanis"));
    Assert.assertTrue(applicationManager.getLoginHelper().isLogged());
  }

  @Test
  public void jutsuTestSendMessage() throws Exception {
    Message message = new Message("Danis");
    applicationManager.getMessageHelper().sendMessage(message);

    Message newMessage = applicationManager.getMessageHelper().getDataSentMessage();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    Assert.assertEquals(message.getTextMessage(), newMessage.getTextMessage());
  }

  @Test
  public void jutsuTestDeleteMessage() throws InterruptedException {
    Integer count1 = applicationManager.getMessageHelper().countMessages();
    applicationManager.getMessageHelper().deleteMessage();
    Thread.sleep(2000);
    Integer count2 = applicationManager.getMessageHelper().countMessages();
    count2++;
    Assert.assertEquals(count1, count2);
  }

}
