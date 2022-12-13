package org.example.generators;

import org.example.models.Message;
import org.example.models.Messages;
import org.example.tests.TestBase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DomGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        GenerateForCreateMessage(count);
    }

    private static void GenerateForCreateMessage(int count) {
        List<Message> messages = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            messages.add(new Message(
                    TestBase.getRandomString(1, 10)
            ));
        }

        try (FileWriter fileWriter = new FileWriter("/home/user/Рабочий стол/MyTests/Tests/Test5/Tests5/src/main/java/org/example/generators/create_message.xml")) {
            writeIdeasToXmlFile(messages, fileWriter);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void writeIdeasToXmlFile(List<Message> messageList, FileWriter fileWriter) {
        try {
            Messages messages = new Messages();
            messages.setMessages(messageList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Messages.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(messages, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}