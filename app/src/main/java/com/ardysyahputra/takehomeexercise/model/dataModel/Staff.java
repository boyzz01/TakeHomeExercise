
package com.ardysyahputra.takehomeexercise.model.dataModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Staff {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("modified_date")
    @Expose
    private String modifiedDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("cover_image")
    @Expose
    private String coverImage;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("wage_amount")
    @Expose
    private int wageAmount;
    @SerializedName("wage_type")
    @Expose
    private String wageType;
    @SerializedName("staff_required")
    @Expose
    private Integer staffRequired;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("min_age")
    @Expose
    private Integer minAge;
    @SerializedName("max_age")
    @Expose
    private Integer maxAge;
    @SerializedName("require_experience")
    @Expose
    private Boolean requireExperience;
    @SerializedName("require_english")
    @Expose
    private Boolean requireEnglish;
    @SerializedName("interview_time")
    @Expose
    private Object interviewTime;
    @SerializedName("interview_info")
    @Expose
    private Object interviewInfo;
    @SerializedName("offer_statistics")
    @Expose
    private OfferStatistics offerStatistics;
    @SerializedName("offer_counts")
    @Expose
    private OfferCounts offerCounts;
    @SerializedName("application_counts")
    @Expose
    private ApplicationCounts applicationCounts;
    @SerializedName("employment_counts")
    @Expose
    private EmploymentCounts employmentCounts;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("fixed_location")
    @Expose
    private Boolean fixedLocation;
    @SerializedName("schedules")
    @Expose
    private List<Schedule> schedules = null;
    @SerializedName("client")
    @Expose
    private Client client;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("position")
    @Expose
    private Position position;
    @SerializedName("manager")
    @Expose
    private Manager manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWageAmount() {
        return wageAmount;
    }

    public void setWageAmount(int wageAmount) {
        this.wageAmount = wageAmount;
    }

    public String getWageType() {
        return wageType;
    }

    public void setWageType(String wageType) {
        this.wageType = wageType;
    }

    public Integer getStaffRequired() {
        return staffRequired;
    }

    public void setStaffRequired(Integer staffRequired) {
        this.staffRequired = staffRequired;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Boolean getRequireExperience() {
        return requireExperience;
    }

    public void setRequireExperience(Boolean requireExperience) {
        this.requireExperience = requireExperience;
    }

    public Boolean getRequireEnglish() {
        return requireEnglish;
    }

    public void setRequireEnglish(Boolean requireEnglish) {
        this.requireEnglish = requireEnglish;
    }

    public Object getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Object interviewTime) {
        this.interviewTime = interviewTime;
    }

    public Object getInterviewInfo() {
        return interviewInfo;
    }

    public void setInterviewInfo(Object interviewInfo) {
        this.interviewInfo = interviewInfo;
    }

    public OfferStatistics getOfferStatistics() {
        return offerStatistics;
    }

    public void setOfferStatistics(OfferStatistics offerStatistics) {
        this.offerStatistics = offerStatistics;
    }

    public OfferCounts getOfferCounts() {
        return offerCounts;
    }

    public void setOfferCounts(OfferCounts offerCounts) {
        this.offerCounts = offerCounts;
    }

    public ApplicationCounts getApplicationCounts() {
        return applicationCounts;
    }

    public void setApplicationCounts(ApplicationCounts applicationCounts) {
        this.applicationCounts = applicationCounts;
    }

    public EmploymentCounts getEmploymentCounts() {
        return employmentCounts;
    }

    public void setEmploymentCounts(EmploymentCounts employmentCounts) {
        this.employmentCounts = employmentCounts;
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

    public Boolean getFixedLocation() {
        return fixedLocation;
    }

    public void setFixedLocation(Boolean fixedLocation) {
        this.fixedLocation = fixedLocation;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

}
