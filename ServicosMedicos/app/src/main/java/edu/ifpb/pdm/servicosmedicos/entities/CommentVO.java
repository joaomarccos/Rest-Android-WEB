package edu.ifpb.pdm.servicosmedicos.entities;

import java.io.Serializable;

/**
 * Created by Rafael on 24/03/2016.
 */
public class CommentVO implements Serializable {

    private String userName;
    private double rating;
    private String comment;
    private long doctorId;

    public CommentVO(String userName, double rating, String comment, long doctorId) {
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
        this.doctorId = doctorId;
    }

    public CommentVO() {
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

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }


}