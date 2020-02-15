
package com.ardysyahputra.takehomeexercise.model.ClockOutModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClockOut {

    @SerializedName("timesheet")
    @Expose
    private Timesheet timesheet;
    @SerializedName("require_feedback")
    @Expose
    private Boolean requireFeedback;

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }

    public Boolean getRequireFeedback() {
        return requireFeedback;
    }

    public void setRequireFeedback(Boolean requireFeedback) {
        this.requireFeedback = requireFeedback;
    }

}
