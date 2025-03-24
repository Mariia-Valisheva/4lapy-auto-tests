package helpers;

import api.GetAuthInfo;
import api.GetCurrentCustomerState;
import api.GetCustomerCardId;
import models.TokenDetails;

public class TestVariables {

    public String getToken() {
        GetAuthInfo getToken = new GetAuthInfo();
        return getToken.ResponseToken().getToken().getAccessToken();
    }

    public String getCustomerId(String token) {
        GetCurrentCustomerState getCurrentCustomerState = new GetCurrentCustomerState();
        return getCurrentCustomerState.getCurrentCustomerState(token).getCustomerId();
    }

    public String getBasketId(String token, String customerId) {
        GetCustomerCardId getCustomerCardId = new GetCustomerCardId();
        return getCustomerCardId.getCustomerCardId(token, customerId).replaceAll("^\"|\"$", "");
    }

    public TokenDetails getAuthInfo() {
        GetAuthInfo getToken = new GetAuthInfo();
        return getToken.ResponseToken().getToken();
    }
}
