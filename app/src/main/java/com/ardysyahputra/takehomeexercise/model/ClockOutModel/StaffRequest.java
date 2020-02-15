package com.ardysyahputra.takehomeexercise.model.ClockOutModel;

import com.ardysyahputra.takehomeexercise.model.dataModel.Client;
import com.ardysyahputra.takehomeexercise.model.dataModel.Location;
import com.ardysyahputra.takehomeexercise.model.dataModel.Position;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StaffRequest {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("client")
    @Expose
    private Client client;
    @SerializedName("position")
    @Expose
    private Position position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
