package fr.moveo.applicationlourde.model;

import java.util.Date;

/**
 * class model Message
 */
public class Message {
    int userid;
    String message;
    Date sentDateTime;

    public Message() {
    }

    public Message(int userid, String message, Date sentDateTime) {
        this.userid = userid;
        this.message = message;
        this.sentDateTime = sentDateTime;
    }

    @Override
    public String toString() {
        return "Message : " +
                "userid=" + userid +
                ", message='" + message + '\'' +
                ", sentDateTime=" + sentDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (userid != message1.userid) return false;
        if (message != null ? !message.equals(message1.message) : message1.message != null) return false;
        return !(sentDateTime != null ? !sentDateTime.equals(message1.sentDateTime) : message1.sentDateTime != null);

    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (sentDateTime != null ? sentDateTime.hashCode() : 0);
        return result;
    }

    public int getUserid() {

        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSentDateTime() {
        return sentDateTime;
    }

    public void setSentDateTime(Date sentDateTime) {
        this.sentDateTime = sentDateTime;
    }
}
