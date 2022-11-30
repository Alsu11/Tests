package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
}
