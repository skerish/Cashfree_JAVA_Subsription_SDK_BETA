package Response;

import java.time.LocalDateTime;

public class SubscriptionObject {

    private String subscriptionId;
    private String subReferenceId;
    private String planId;
    private String authLink;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String mode;
    private String cardNumber;
    private String status;
    private String bankAccountNumber;
    private String bankAccountHolder;
    private String umrn;

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getBankAccountHolder() {
        return bankAccountHolder;
    }

    public String getUmrn() {
        return umrn;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getMode() {
        return mode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public String getSubReferenceId() {
        return subReferenceId;
    }

    public String getPlanId() {
        return planId;
    }

    public String getAuthLink() {
        return authLink;
    }
}
