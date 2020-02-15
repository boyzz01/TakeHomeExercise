
package com.ardysyahputra.takehomeexercise.model.dataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplicationCounts {

    @SerializedName("pending_onboarding")
    @Expose
    private Integer pendingOnboarding;
    @SerializedName("applied")
    @Expose
    private Integer applied;
    @SerializedName("pending_contract")
    @Expose
    private Integer pendingContract;
    @SerializedName("rejected")
    @Expose
    private Integer rejected;
    @SerializedName("withdrawn")
    @Expose
    private Integer withdrawn;
    @SerializedName("hired")
    @Expose
    private Integer hired;

    public Integer getPendingOnboarding() {
        return pendingOnboarding;
    }

    public void setPendingOnboarding(Integer pendingOnboarding) {
        this.pendingOnboarding = pendingOnboarding;
    }

    public Integer getApplied() {
        return applied;
    }

    public void setApplied(Integer applied) {
        this.applied = applied;
    }

    public Integer getPendingContract() {
        return pendingContract;
    }

    public void setPendingContract(Integer pendingContract) {
        this.pendingContract = pendingContract;
    }

    public Integer getRejected() {
        return rejected;
    }

    public void setRejected(Integer rejected) {
        this.rejected = rejected;
    }

    public Integer getWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(Integer withdrawn) {
        this.withdrawn = withdrawn;
    }

    public Integer getHired() {
        return hired;
    }

    public void setHired(Integer hired) {
        this.hired = hired;
    }

}
