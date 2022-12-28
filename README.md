SUBSCRIPTION JAVA SDK

Use our Java SDK to instantly integrate our Subscription product services into your application.


Prerequisites:

Before initiating any service request, the user has to create an object of the subscription class and pass the valid appId and secretKey along with the Environment they want to use(TEST or PROD).

Subscription subscription = Subscription.getInstance("APP_ID", "SECRET_KEY", Environment.TEST);



Creating an ON_DEMAN Plan

In order to create an on-demand plan, the user has to create an object of the “CreateOnDemandPlanRequest” class and pass all the required parameters, some parameters are mandatory here and need to be passed otherwise will throw a runtime error. The user can refer to our Cashfree API documentation to know what are the mandatory parameters.



Creating a PERIODIC Plan

In order to create a periodic plan, the user has to create an object of the “CreatePeriodicPlanRequest” class and similarly pass all required parameters. 


Creating a Subscription

Once the plans are created, the user can create a subscription by creating an object of the “CreateSubsciptionRequest” class. They can pass the planId of either a periodic or on_demand plan here. Based on the plan selected, the user has to pass the required parameters here(Since some parameters are only applicable to a certain type of Plan). 

To set the FirstChargeDate and ExpiresOn date, the user has to pass the object of the “LocalDateTime” class.



Getting an already existing Subscription details

To get the details of a particular subscription, the user can create an object of the “GetSubscriptionResponse” class and then call the method getSubsciptionDetails() by passing the subReferenceId of an already existing subscription on the account.



