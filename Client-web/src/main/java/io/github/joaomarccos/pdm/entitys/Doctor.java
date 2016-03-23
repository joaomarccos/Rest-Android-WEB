package io.github.joaomarccos.pdm.entitys;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class Doctor {

    private long id;
    private String name;
    private String contact;
    private String location;
    private String specialty;
    private String opinion;
    private double rating;
    
    private Clinic clinic;

    public Doctor() {
    }

    public Doctor(String name, String contact, String location, String specialty, Clinic clinic) {
        this.name = name;
        this.contact = contact;
        this.location = location;
        this.specialty = specialty;
        this.clinic = clinic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

}
