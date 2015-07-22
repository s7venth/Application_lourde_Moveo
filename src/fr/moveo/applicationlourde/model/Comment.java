package fr.moveo.applicationlourde.model;

import java.util.Date;

/**
 * Class Comment
 */
public class Comment {
    private int commentId, userId, tripId;
    private String commentMessage, commentUserLastName, commentUserFirstName;
    private Date commentCreation;

    /**
     * the constructor
     */
    public Comment() {
    }

    /**
     * the second constructor
     * @param commentId the id of the comment
     * @param userId the userId of the user who emit comment
     * @param tripId the tripId concerned by this comment
     * @param commentMessage the message of the comment
     * @param commentUserLastName the lastname of the user who emit comment
     * @param commentUserFirstName the firstname of the user who emit comment
     * @param commentCreation the date of creation of the comment
     */
    public Comment(int commentId, int userId, int tripId, String commentMessage, String commentUserLastName, String commentUserFirstName, Date commentCreation) {
        this.commentId = commentId;
        this.userId = userId;
        this.tripId = tripId;
        this.commentMessage = commentMessage;
        this.commentUserLastName = commentUserLastName;
        this.commentUserFirstName = commentUserFirstName;
        this.commentCreation = commentCreation;
    }

    public String getCommentUserLastName() {
        return commentUserLastName;
    }

    public void setCommentUserLastName(String commentUserLastName) {
        this.commentUserLastName = commentUserLastName;
    }

    public String getCommentUserFirstName() {
        return commentUserFirstName;
    }

    public void setCommentUserFirstName(String commentUserFirstName) {
        this.commentUserFirstName = commentUserFirstName;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public Date getCommentCreation() {
        return commentCreation;
    }

    public void setCommentCreation(Date commentCreation) {
        this.commentCreation = commentCreation;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", tripId=" + tripId +
                ", commentMessage='" + commentMessage + '\'' +
                ", commentUserLastName='" + commentUserLastName + '\'' +
                ", commentUserFirstName='" + commentUserFirstName + '\'' +
                ", commentCreation=" + commentCreation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentId != comment.commentId) return false;
        if (userId != comment.userId) return false;
        if (tripId != comment.tripId) return false;
        if (commentMessage != null ? !commentMessage.equals(comment.commentMessage) : comment.commentMessage != null)
            return false;
        if (commentUserLastName != null ? !commentUserLastName.equals(comment.commentUserLastName) : comment.commentUserLastName != null)
            return false;
        if (commentUserFirstName != null ? !commentUserFirstName.equals(comment.commentUserFirstName) : comment.commentUserFirstName != null)
            return false;
        return !(commentCreation != null ? !commentCreation.equals(comment.commentCreation) : comment.commentCreation != null);

    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + userId;
        result = 31 * result + tripId;
        result = 31 * result + (commentMessage != null ? commentMessage.hashCode() : 0);
        result = 31 * result + (commentUserLastName != null ? commentUserLastName.hashCode() : 0);
        result = 31 * result + (commentUserFirstName != null ? commentUserFirstName.hashCode() : 0);
        result = 31 * result + (commentCreation != null ? commentCreation.hashCode() : 0);
        return result;
    }
}
