package fr.moveo.applicationlourde.model;

import javax.swing.*;
import java.util.Date;

/**
 * Created by alexMac on 08/05/15.
 * Classe model Trip permettant d'utiliser les Voyages.
 */

public class Trip {
    int id;
    String country, name, description;
    ImageIcon mainPicture;
    User user;
    String author_last_name;
    String author_first_name;
    int commentCount;
    int photoCount;
    Date dateCreation;

    public Trip() {}

    public Trip(String country, String name, String description) {

        this.country = country;
        this.name = name;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageIcon getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(ImageIcon mainPicture) {
        this.mainPicture = mainPicture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthor_last_name() {
        return author_last_name;
    }

    public void setAuthor_last_name(String author_last_name) {
        this.author_last_name = author_last_name;
    }

    public String getAuthor_first_name() {
        return author_first_name;
    }

    public void setAuthor_first_name(String author_first_name) {
        this.author_first_name = author_first_name;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (id != trip.id) return false;
        if (commentCount != trip.commentCount) return false;
        if (photoCount != trip.photoCount) return false;
        if (country != null ? !country.equals(trip.country) : trip.country != null) return false;
        if (name != null ? !name.equals(trip.name) : trip.name != null) return false;
        if (description != null ? !description.equals(trip.description) : trip.description != null) return false;
        if (mainPicture != null ? !mainPicture.equals(trip.mainPicture) : trip.mainPicture != null) return false;
        if (user != null ? !user.equals(trip.user) : trip.user != null) return false;
        if (author_last_name != null ? !author_last_name.equals(trip.author_last_name) : trip.author_last_name != null)
            return false;
        if (author_first_name != null ? !author_first_name.equals(trip.author_first_name) : trip.author_first_name != null)
            return false;
        return !(dateCreation != null ? !dateCreation.equals(trip.dateCreation) : trip.dateCreation != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (mainPicture != null ? mainPicture.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (author_last_name != null ? author_last_name.hashCode() : 0);
        result = 31 * result + (author_first_name != null ? author_first_name.hashCode() : 0);
        result = 31 * result + commentCount;
        result = 31 * result + photoCount;
        result = 31 * result + (dateCreation != null ? dateCreation.hashCode() : 0);
        return result;
    }

    public String toStringList() {
        return "id= "+ id +", name='" + name;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mainPicture=" + mainPicture +
                ", user=" + user +
                ", author_last_name='" + author_last_name + '\'' +
                ", author_first_name='" + author_first_name + '\'' +
                ", commentCount=" + commentCount +
                ", photoCount=" + photoCount +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
