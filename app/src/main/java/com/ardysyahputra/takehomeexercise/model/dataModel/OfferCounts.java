
package com.ardysyahputra.takehomeexercise.model.dataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OfferCounts {

    @SerializedName("sent")
    @Expose
    private Integer sent;
    @SerializedName("viewed")
    @Expose
    private Integer viewed;
    @SerializedName("applied")
    @Expose
    private Integer applied;
    @SerializedName("pending_onboarding")
    @Expose
    private Integer pendingOnboarding;
    @SerializedName("pending_contract")
    @Expose
    private Integer pendingContract;
    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("withdrawn")
    @Expose
    private Integer withdrawn;
    @SerializedName("rejected")
    @Expose
    private Integer rejected;
    @SerializedName("cancelled")
    @Expose
    private Integer cancelled;
    @SerializedName("no_show")
    @Expose
    private Integer noShow;
    @SerializedName("contract_ended")
    @Expose
    private Integer contractEnded;

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

    public Integer getPendingOnboarding() {
        return pendingOnboarding;
    }

    public void setPendingOnboarding(Integer pendingOnboarding) {
        this.pendingOnboarding = pendingOnboarding;
    }

    public Integer getPendingContract() {
        return pendingContract;
    }

    public void setPendingContract(Integer pendingContract) {
        this.pendingContract = pendingContract;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(Integer withdrawn) {
        this.withdrawn = withdrawn;
    }

    public Integer getRejected() {
        return rejected;
    }

    public void setRejected(Integer rejected) {
        this.rejected = rejected;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

    public Integer getNoShow() {
        return noShow;
    }

    public void setNoShow(Integer noShow) {
        this.noShow = noShow;
    }

    public Integer getContractEnded() {
        return contractEnded;
    }

    public void setContractEnded(Integer contractEnded) {
        this.contractEnded = contractEnded;
    }

}
