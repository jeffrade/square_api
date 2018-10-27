package com.github.jeffrade.square.api.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OAuth2Service {

    public static final String DEFAULT_PERMISSION_SCOPE = "MERCHANT_PROFILE_READ PAYMENTS_READ SETTLEMENTS_READ BANK_ACCOUNTS_READ";

    /**
     * List of scopes can be found at https://docs.connect.squareup.com/api/oauth#permissionscope
     *
     * @param clientId
     * @param scope
     * @return
     */
    @GET("oauth2/authorize")
    Call<ResponseBody> authorize(@Query("client_id") String clientId, @Query("scope") String scope);

    @POST("oauth2/token")
    Call<ResponseBody> token(@Body String body);
}
