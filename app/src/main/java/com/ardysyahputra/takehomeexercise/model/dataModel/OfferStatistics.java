
package com.ardysyahputra.takehomeexercise.model.dataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OfferStatistics {

    @SerializedName("sent")
    @Expose
    private Integer sent;
    @SerializedName("viewed")
    @Expose
    private Integer viewed;
    @SerializedName("applied")
    @Expose
    private Integer applied;
    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;

    public Integer getSent() {
        return sent;
    }

    public void setSent(Integer sent) {
        this.sent = sent;
    }

    public Integer getViewed() {
        return viewed;
    }

    public void setViewed(Integer viewed) {
        this.viewed = viewed;
    }

    public Integer getApplied() {
        return applied;
    }

    public void setApplied(Integer applied) {
        this.applied = applied;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

}
