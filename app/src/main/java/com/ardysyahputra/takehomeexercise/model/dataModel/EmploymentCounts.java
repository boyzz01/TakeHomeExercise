
package com.ardysyahputra.takehomeexercise.model.dataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmploymentCounts {

    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("cancelled")
    @Expose
    private Integer cancelled;
    @SerializedName("ended")
    @Expose
    private Integer ended;

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

    public Integer getEnded() {
        return ended;
    }

    public void setEnded(Integer ended) {
        this.ended = ended;
    }

}
