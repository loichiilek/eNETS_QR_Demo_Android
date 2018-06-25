package com.nets_qr_api;

/**
 * Created by chiilek on 22/6/2018.
 */

import com.request.RequestBody;
import com.response.ResponseBody;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NETSQRAPI {

    @Headers({
            "KeyId:b027dacd-1c13-4916-8b93-38fae6be2f80",
            "Content-Type:application/json"
    })
    @POST("qr/dynamic/v1/order/request")
    Call<ResponseBody> getQRCode(@Body RequestBody body, @HeaderMap Map<String, String> headers);

}
