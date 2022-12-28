package Constants;

public class Endpoint {

    private static final String prod = "https://api.cashfree.com";
    private static final String test = "https://test.cashfree.com";

    public static String getProdEndpoint() {
        return prod;
    }

    public static String getTestEndpoint() {
        return test;
    }
}
