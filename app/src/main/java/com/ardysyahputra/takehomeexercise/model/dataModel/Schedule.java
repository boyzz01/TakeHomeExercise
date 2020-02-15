
package com.ardysyahputra.takehomeexercise.model.dataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedule {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("staff_request")
    @Expose
    private Integer staffRequest;
    @SerializedName("recurrences")
    @Expose
    private String recurrences;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("duration")
    @Expose
    private String duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffRequest() {
        return staffRequest;
    }

    public void setStaffRequest(Integer staffRequest) {
        this.staffRequest = staffRequest;
    }

    public String getRecurrences() {
        return recurrences;
    }

    public void setRecurrences(String recurrences) {
        this.recurrences = recurrences;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
