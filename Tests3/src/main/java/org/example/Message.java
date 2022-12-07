package org.example;


public class Message {
    private String textMessage;
    private String to;

    public Message(String textMessage) {
        this.textMessage = textMessage;
    }

    public Message(String textMessage, String to) {
        this.textMessage = textMessage;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Message{" +
                "textMessage='" + textMessage + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
