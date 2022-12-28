import Annotations.NotNull;
import Constants.ApiUrlConstants;
import Constants.Endpoint;
import Constants.Environment;
import ObjectMap.ObjectMappingUtils;
import ObjectMap.ObjectWriterUtils;
import Request.CreateOnDemandPlanRequest;
import Request.CreatePeriodicPlanRequest;
import Request.CreateSubscriptionRequest;
import Response.CreatePlanResponse;
import Response.CreateSubscriptionResponse;
import Response.GetSubscriptionResponse;
import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Subscription {

    private static String appId, secretKey, endpoint;

    private static Subscription SINGLETON_INSTANCE;

    private Subscription(String appId, String secretKey, Environment environment){
        Subscription.appId = appId;
        Subscription.secretKey = secretKey;
        if (Environment.TEST.equals(environment))
            endpoint = Endpoint.getTestEndpoint();
        else if (Environment.PRODUCTION.equals(environment))
            endpoint = Endpoint.getProdEndpoint();
    }

    public static Subscription getInstance(String appId, String secretKey, Environment environment){
        if (SINGLETON_INSTANCE == null)
            SINGLETON_INSTANCE = new Subscription(appId, secretKey, environment);
        return SINGLETON_INSTANCE;
    }

    private Map<String, String> buildPostHeader(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Client-Id", appId);
        headers.put("X-Client-Secret", secretKey);
        return headers;
    }

    private static <T> Map<Object, Object> getObjectAsMap(T object, Class<T> clazz) {
        if (object == null) return Collections.emptyMap();
        Map<Object, Object> map = new HashMap<>();
        for (Field field: ObjectMappingUtils.getAllFields(clazz)) {
            Object fieldValue = null;
            Annotation annotation = field.getAnnotation(NotNull.class);
            if (annotation != null) {
                // Field is a required field.
                fieldValue = ObjectWriterUtils.getField(field, object);
                if (fieldValue == null) {
                    throw new IllegalArgumentException("Field: " + field.getName() + " of type: " + field.getType() +
                            " in object of class: " + clazz.getName() + " can't be null as it is a required field.");
                }
            }
            if (fieldValue != null) {
                map.put(field.getName(), fieldValue);
            }
        }
        return map;
    }

    <Request, Response> Response performPostRequest(String reqUrl, Request request, Class<Request> requestClass, Class<Response> responseClass) {
        Map<Object, Object> requestAsMap = getObjectAsMap(request, requestClass);
        System.out.println(requestAsMap);
        return performPostRequest(reqUrl, requestAsMap, responseClass);
    }

    <Response> Response performPostRequest(String reqUrl, Map<Object, Object> requestAsMap, Class<Response> responseClass){
        String jsonString = getJsonFromMap(requestAsMap);
        Response body = HttpUtils.performPostRequest(endpoint+reqUrl, buildPostHeader(), jsonString, responseClass);
        return body;
    }

    private String getJsonFromMap(Map<Object, Object> requestAsMap) {
        return new Gson().toJson(requestAsMap);
    }

    public CreatePlanResponse createOnDemandPlan(CreateOnDemandPlanRequest request){
        return SINGLETON_INSTANCE.performPostRequest(ApiUrlConstants.CREATE_PLAN_URL, request, CreateOnDemandPlanRequest.class, CreatePlanResponse.class);
    }

    public CreatePlanResponse createPeriodicPlan(CreatePeriodicPlanRequest request){
        return SINGLETON_INSTANCE.performPostRequest(ApiUrlConstants.CREATE_PLAN_URL, request, CreatePeriodicPlanRequest.class, CreatePlanResponse.class);
    }

    public CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest request){
        return SINGLETON_INSTANCE.performPostRequest(ApiUrlConstants.CREATE_SUBSCRIPTION_URL, request, CreateSubscriptionRequest.class, CreateSubscriptionResponse.class);
    }

    public GetSubscriptionResponse getSubscriptionDetails(String subReferenceID){
        return HttpUtils.performGetRequest(endpoint + ApiUrlConstants.GET_SUBSCRIPTION_URL + subReferenceID, buildPostHeader(), GetSubscriptionResponse.class);
    }

}
