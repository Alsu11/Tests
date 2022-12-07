package org.example.generators;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.example.models.Message;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DomGenerator {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            // создаем пустой объект Document, в котором будем создавать наш xml-файл
            Document doc = builder.newDocument();

            // создаем корневой элемент
            Element rootElement =
                    doc.createElementNS("http://www.w3.org/2001/XMLSchema-instance", "Messages");

            // добавляем корневой элемент в объект Document
            doc.appendChild(rootElement);

            // добавляем дочерние элементы в файл
            List<Message> messages = inputData();
            for(Integer i = 0; i < messages.size(); i++) {
                Message message = messages.get(i);
                rootElement.appendChild(getLanguage(doc, i.toString(), message.getTextMessage(), "PoshKamil"));
            }

            //создаем объект TransformerFactory для печати в консоль
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // для красивого вывода в консоль
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //печатаем в консоль или файл
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("/home/user/Рабочий стол/generated_data/messages.xml"));

            //записываем данные
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Создание XML файла закончено");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // метод для создания нового узла XML-файла
    private static Node getLanguage(Document doc, String id, String messageText, String to) {
        Element language = doc.createElement("Message");

        // устанавливаем атрибут id
        language.setAttribute("id", id);

        // создаем элемент message
        language.appendChild(getLanguageElements(doc, language, "message", messageText));

        // создаем элемент to
        language.appendChild(getLanguageElements(doc, language, "to", to));
        return language;
    }


    // утилитный метод для создание нового узла XML-файла
    private static Node getLanguageElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    private static List<Message> inputData() {
        List<Message> messages = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String mess = scanner.next();
            messages.add(new Message(mess));
        }
        return messages;
    }

}