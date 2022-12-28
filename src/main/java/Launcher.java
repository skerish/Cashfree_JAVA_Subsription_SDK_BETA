import Constants.Environment;
import Request.CreateOnDemandPlanRequest;
import Request.CreatePeriodicPlanRequest;
import Request.CreateSubscriptionRequest;
import Response.CreatePlanResponse;
import Response.CreateSubscriptionResponse;
import Response.GetSubscriptionResponse;

import java.time.LocalDate;

public class Launcher {

    public static void main(String[] args) {

        Subscription subscription = Subscription.getInstance("CLIENT_ID", "CLIENT_SECRET", Environment.TEST);

        CreateOnDemandPlanRequest onDemandPlanRequest = new CreateOnDemandPlanRequest();
        onDemandPlanRequest.setPlanId("final_test_demand_plan_02");
        onDemandPlanRequest.setPlanName("Test On-Demand Plan");
        onDemandPlanRequest.setMaxAmount(1000);
        onDemandPlanRequest.setMaxCycles(3);
        onDemandPlanRequest.setDescription("Test sub");

        CreatePlanResponse createOnDemandPlanResponse = subscription.createOnDemandPlan(onDemandPlanRequest);
        System.out.println(createOnDemandPlanResponse);

        CreatePeriodicPlanRequest periodicPlanRequest = new CreatePeriodicPlanRequest();
        periodicPlanRequest.setPlanId("final_test_periodic_plan-02");
        periodicPlanRequest.setPlanName("Test Periodic Plan");
        periodicPlanRequest.setAmount(500);
        periodicPlanRequest.setIntervalType("week");
        periodicPlanRequest.setIntervals(3);
        periodicPlanRequest.setDescription("This is a test periodic plan");

        CreatePlanResponse createPeriodicPlanResponse = subscription.createPeriodicPlan(periodicPlanRequest);
        System.out.println(createPeriodicPlanResponse);

        CreateSubscriptionRequest subscriptionRequest = new CreateSubscriptionRequest();
        subscriptionRequest.setSubscriptionId("test_sub_281212-004");
        subscriptionRequest.setPlanId("test_periodic_plan_281222-001");
        subscriptionRequest.setCustomerEmail("cashfree@test.com");
        subscriptionRequest.setCustomerPhone("9999999999");
        subscriptionRequest.setCustomerName("Jerry");
        subscriptionRequest.setReturnUrl("https://www.google.com/");
        subscriptionRequest.setSubscriptionNote("Test Note");
        subscriptionRequest.setAuthAmount(5);
        subscriptionRequest.setFirstChargeDate(LocalDate.of(2023,1,5));
        subscriptionRequest.setExpiresOn(LocalDate.of(2023,6,1));

        CreateSubscriptionResponse createSubscriptionResponse = subscription.createSubscription(subscriptionRequest);
        System.out.println(createSubscriptionResponse);


        GetSubscriptionResponse getSubscriptionResponse = subscription.getSubscriptionDetails("104953");
        System.out.println(getSubscriptionResponse);

    }
}
