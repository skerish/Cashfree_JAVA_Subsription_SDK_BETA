package Response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class GetSubscriptionResponse {
    private String status;
    private String message;
    private SubscriptionObject subscription;

    @Override
    public String toString() {
        return "GetSubscriptionResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", subscription={" +
                    "subscriptionId='" + subscription.getSubscriptionId() + '\'' +
                    ", subReferenceId='" + subscription.getSubReferenceId() + '\'' +
                    ", planId='" + subscription.getPlanId() + '\'' +
                    ", authLink='" + subscription.getAuthLink() + '\'' +
                    ", customerName='" + subscription.getCustomerName() + '\'' +
                    ", customerEmail='" + subscription.getCustomerEmail() + '\'' +
                    ", customerPhone='" + subscription.getCustomerPhone() + '\'' +
                    ", mode='" + subscription.getMode() + '\'' +
                    ", cardNumber='" + subscription.getCardNumber() + '\'' +
                    ", status='" + subscription.getStatus() + '\'' +
                    ", bankAccountNumber='" + subscription.getBankAccountNumber() + '\'' +
                    ", bankAccountHolder='" + subscription.getBankAccountHolder() + '\'' +
                    ", umrn='" + subscription.getUmrn() + '\'' +
                    '}'+ '}';
    }
}