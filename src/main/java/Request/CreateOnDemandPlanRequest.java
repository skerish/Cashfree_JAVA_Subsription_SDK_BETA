package Request;

import Annotations.NotNull;

public class CreateOnDemandPlanRequest {

    @NotNull
    private String planId;

    @NotNull
    private String planName;

    @NotNull
    private final String type = "ON_DEMAND";

    @NotNull
    private int maxCycles;

    @NotNull
    private float maxAmount;

    private String description;

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setMaxCycles(int maxCycles) {
        this.maxCycles = maxCycles;
    }

    public void setMaxAmount(float maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlanId() {
        return planId;
    }

    public String getPlanName() {
        return planName;
    }

    public String getType() {
        return type;
    }

    public int getMaxCycles() {
        return maxCycles;
    }

    public float getMaxAmount() {
        return maxAmount;
    }

    public String getDescription() {
        return description;
    }

}
