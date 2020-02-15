
package com.ardysyahputra.takehomeexercise.model.ClockOutModel;

import com.ardysyahputra.takehomeexercise.model.ClockInModel.Partner;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timesheet {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("clock_in_time")
    @Expose
    private String clockInTime;
    @SerializedName("clock_out_time")
    @Expose
    private String clockOutTime;
    @SerializedName("clock_in_latitude")
    @Expose
    private String clockInLatitude;
    @SerializedName("clock_in_longitude")
    @Expose
    private String clockInLongitude;
    @SerializedName("clock_out_latitude")
    @Expose
    private String clockOutLatitude;
    @SerializedName("clock_out_longitude")
    @Expose
    private String clockOutLongitude;
    @SerializedName("partner")
    @Expose
    private Partner partner;
    @SerializedName("timesheet")
    @Expose
    private Integer timesheet;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("staff_request")
    @Expose
    private StaffRequest staffRequest;
    @SerializedName("schedule")
    @Expose
    private Object schedule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(String clockInTime) {
        this.clockInTime = clockInTime;
    }

    public String getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(String clockOutTime) {
        this.clockOutTime = clockOutTime;
    }

    public String getClockInLatitude() {
        return clockInLatitude;
    }

    public void setClockInLatitude(String clockInLatitude) {
        this.clockInLatitude = clockInLatitude;
    }

    public String getClockInLongitude() {
        return clockInLongitude;
    }

    public void setClockInLongitude(String clockInLongitude) {
        this.clockInLongitude = clockInLongitude;
    }

    public String getClockOutLatitude() {
        return clockOutLatitude;
    }

    public void setClockOutLatitude(String clockOutLatitude) {
        this.clockOutLatitude = clockOutLatitude;
    }

    public String getClockOutLongitude() {
        return clockOutLongitude;
    }

    public void setClockOutLongitude(String clockOutLongitude) {
        this.clockOutLongitude = clockOutLongitude;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Integer getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Integer timesheet) {
        this.timesheet = timesheet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public StaffRequest getStaffRequest() {
        return staffRequest;
    }

    public void setStaffRequest(StaffRequest staffRequest) {
        this.staffRequest = staffRequest;
    }

    public Object getSchedule() {
        return schedule;
    }

    public void setSchedule(Object schedule) {
        this.schedule = schedule;
    }

}
