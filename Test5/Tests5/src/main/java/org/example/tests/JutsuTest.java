package org.example.tests;// Generated by Selenium IDE

import org.example.generators.DomParser;
import org.example.models.Account;
import org.example.models.Message;
import org.example.models.Messages;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Theories.class)
public class JutsuTest extends TestBase {

  @Test
  public void jutsuTestLogin() {
    applicationManager.getNavigationHelper().openHomePage();
    applicationManager.getLoginHelper().login(new Account("PoshKamil", "danisdanis"));
    Assert.assertTrue(applicationManager.getLoginHelper().isLogged());
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

  //@Test
  public void jutsuTestDeleteMessage() throws InterruptedException {
    Integer count1 = applicationManager.getMessageHelper().countMessages();
    applicationManager.getMessageHelper().deleteMessage();
    Thread.sleep(2000);
    Integer count2 = applicationManager.getMessageHelper().countMessages();
    count2++;
    Assert.assertEquals(count1, count2);
  }

  @DataPoints
  public static List<Message> messagesFromXmlFile() {
    try {
      JAXBContext context = JAXBContext.newInstance(Messages.class);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      Messages messages = (Messages) unmarshaller.unmarshal(new File("/home/user/Рабочий стол/MyTests/Tests/Test5/Tests5/src/main/java/org/example/generators/create_message.xml"));
      return messages.getMessages();
    } catch (JAXBException exception) {
      throw new RuntimeException(exception);
    }
  }


}
