package org.example.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "messages")
@XmlAccessorType(XmlAccessType.FIELD)
public class Messages {
    @XmlElement(name = "message")
    private List<Message> messages;

    public void setMessages(List<Message> messages){
        this.messages = messages;
    }

    public List<Message> getMessages(){
        return messages;
    }

    public Messages(){}
}
