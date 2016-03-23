package edu.ifpb.pdm.servicosmedicos.entities;

/**
 * Created by Rafael on 23/03/2016.
 */
public class Clinic {
    private long id;
    private String name;
    private String coord_lat;
    private String coord_lng;

    public Clinic(long id, String name, String coord_lat, String coord_lng) {
        this.id = id;
        this.name = name;
        this.coord_lat = coord_lat;
        this.coord_lng = coord_lng;
    }

    public Clinic(String name) {
        this.name = name;
    }

    public Clinic() {
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

    public String getCoord_lat() {
        return coord_lat;
    }

    public void setCoord_lat(String coord_lat) {
        this.coord_lat = coord_lat;
    }

    public String getCoord_lng() {
        return coord_lng;
    }

    public void setCoord_lng(String coord_lng) {
        this.coord_lng = coord_lng;
    }
}
