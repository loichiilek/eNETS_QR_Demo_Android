package com.nets_qr_api;

import android.util.Log;

import com.request.RequestBody;
import com.response.ErrorMessage;
import com.response.ResponseBody;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chiilek on 22/6/2018.
 */

public class NETS_QR_APIController implements Callback<ResponseBody> {

    private static final String URL = "https://uat-api.nets.com.sg:9065/uat/merchantservices/";

    private NETSQRCallback mnetsqrCallback;

    public void makecall(RequestBody requestBody, String signature, NETSQRCallback netsqrCallback) {
        mnetsqrCallback = netsqrCallback;

        Map<String, String> headers = new HashMap<>();
        headers.put("Sign", signature);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NETSQRAPI netsqrapi = retrofit.create(NETSQRAPI.class);
        Call<ResponseBody> call = netsqrapi.getQRCode(requestBody, headers);
        Log.d("NETS_QR_APIController", call.request().headers().toString());
        Log.d("NETS_QR_APIController", call.request().body().toString());
        Log.d("NETS_QR_APIController**", bodyToString(call.request()));
        Log.d("NETS_QR_APIController", call.request().toString());

        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        Log.d("NETS_QR_APIController","On Response from call, response code: " + Integer.toString(response.code()));
        ResponseBody responseBody = response.body();
        mnetsqrCallback.onSuccess(responseBody);

        // For error codes
        if (response.code() != 210) {
            Log.d("NETS_QR_APIController", "onResponse - Status : " + response.code());
            Gson gson = new Gson();
            TypeAdapter<ErrorMessage> adapter = gson.getAdapter(ErrorMessage.class);
            try {
                ErrorMessage errorMessage = null;
                if (response.errorBody() != null)
                    errorMessage = adapter.fromJson(response.errorBody().string());
                if (errorMessage != null) {
                    Log.d("NETS_QR_APIController", errorMessage.getMessage());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Log.d("NETS_QR_APIController", "onFailure, error message: " + t.getMessage());
        t.getStackTrace();
    }

    private static String bodyToString(final Request request){

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }


}
