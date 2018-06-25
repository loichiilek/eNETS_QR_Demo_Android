package com.nets_qr_api;

import com.response.ResponseBody;

/**
 * Created by chiilek on 25/6/2018.
 */

public interface NETSQRCallback {
    void onSuccess(ResponseBody responseBody);
    void onFailure();
}
