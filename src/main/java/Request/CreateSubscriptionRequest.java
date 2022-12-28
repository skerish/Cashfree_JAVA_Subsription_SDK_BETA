package Request;

import Annotations.NotNull;

import java.time.LocalDate;

public class CreateSubscriptionRequest {

    @NotNull
    private String subscriptionId;

    @NotNull
    private String planId;

    @NotNull
    private String customerEmail;

    @NotNull
    private String customerPhone;

    private String customerName;

    private float authAmount;

    private LocalDate firstChargeDate;

    private LocalDate expiresOn;

    @NotNull
    private String returnUrl;

    private String subscriptionNote;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getFirstChargeDate() {
        return firstChargeDate;
    }

    public void setFirstChargeDate(LocalDate firstChargeDate) {
        this.firstChargeDate = firstChargeDate;
    }

    public float getAuthAmount() {
        return authAmount;
    }

    public void setAuthAmount(float authAmount) {
        this.authAmount = authAmount;
    }

    public LocalDate getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(LocalDate expiresOn) {
        this.expiresOn = expiresOn;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getSubscriptionNote() {
        return subscriptionNote;
    }

    public void setSubscriptionNote(String subscriptionNote) {
        this.subscriptionNote = subscriptionNote;
    }
}
