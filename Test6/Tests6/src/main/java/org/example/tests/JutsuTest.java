package org.example.tests;// Generated by Selenium IDE

import org.example.generators.DomParser;
import org.example.models.Message;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Theories.class)
public class JutsuTest extends AuthBase {

  @DataPoints
  public static List<Message> readXml() {
    DomParser domP = new DomParser();
    List<Message> messages = domP.readXml("C:\\xml\\messages.xml");
    return messages;
  }

  @Test
  @Theory
  public void jutsuTestSendMessage(Message message) throws Exception {
    applicationManager.getMessageHelper().sendMessage(message);

    Message newMessage = applicationManager.getMessageHelper().getDataSentMessage();

    try {
      Thread.sleep(1000);
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
