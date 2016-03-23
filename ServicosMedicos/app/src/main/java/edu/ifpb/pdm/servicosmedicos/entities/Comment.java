package edu.ifpb.pdm.servicosmedicos.entities;

/**
 * Created by Rafael on 23/03/2016.
 */
public class Comment {
    private long id;
    private String userName;
    private double rating;
    private String comment;
    private long doctorId;

    public Comment(String userName, double rating, String comment, long doctor_id) {
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
        this.doctorId = doctor_id;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctor_id) {
        this.doctorId = doctor_id;
    }
}
