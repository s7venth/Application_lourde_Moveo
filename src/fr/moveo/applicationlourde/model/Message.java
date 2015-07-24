package fr.moveo.applicationlourde.model;

import java.util.Date;

/**
 * class model Message
 */
public class Message {
    int userid;
    String message, firstname, lastname;
    Date sentDateTime;

    public Message() {
    }

    public Message(int userid, String message, String firstname, String lastname, Date sentDateTime) {
        this.userid = userid;
        this.message = message;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sentDateTime = sentDateTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "userid=" + userid +
                ", message='" + message + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", sentDateTime=" + sentDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (userid != message1.userid) return false;
        if (message != null ? !message.equals(message1.message) : message1.message != null) return false;
        if (firstname != null ? !firstname.equals(message1.firstname) : message1.firstname != null) return false;
        if (lastname != null ? !lastname.equals(message1.lastname) : message1.lastname != null) return false;
        return !(sentDateTime != null ? !sentDateTime.equals(message1.sentDateTime) : message1.sentDateTime != null);

    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getSentDateTime() {
        return sentDateTime;
    }

    public void setSentDateTime(Date sentDateTime) {
        this.sentDateTime = sentDateTime;
    }
}
