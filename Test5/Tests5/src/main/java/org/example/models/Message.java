package org.example.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
    @XmlElement(name = "text", required = true)
    private String textMessage;
    @XmlElement(name = "to", required = true)
    private String to = "PoshKamil";

    public Message(String textMessage, String to) {
        this.textMessage = textMessage;
        this.to = to;
    }

    public Message(){}
    public Message(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Message{" +
                "textMessage='" + textMessage + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
