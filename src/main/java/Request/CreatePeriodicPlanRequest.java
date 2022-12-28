package Request;

import Annotations.NotNull;

public class CreatePeriodicPlanRequest {

    @NotNull
    private String planId;

    @NotNull
    private String planName;

    @NotNull
    private final String type = "PERIODIC";

    @NotNull
    private float amount;

    @NotNull
    private String intervalType;

    @NotNull
    private int intervals;

    private String description;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getIntervalType() {
        return intervalType;
    }

    public void setIntervalType(String intervalType) {
        this.intervalType = intervalType;
    }

    public int getIntervals() {
        return intervals;
    }

    public void setIntervals(int intervals) {
        this.intervals = intervals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
