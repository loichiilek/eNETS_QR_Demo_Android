
package com.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Addon {

    @SerializedName("external_API_keyID")
    @Expose
    private String externalAPIKeyID;

    public Addon(String externalAPIKeyID) {
        this.externalAPIKeyID = externalAPIKeyID;
    }

    public String getExternalAPIKeyID() {
        return externalAPIKeyID;
    }

    public void setExternalAPIKeyID(String externalAPIKeyID) {
        this.externalAPIKeyID = externalAPIKeyID;
    }

}
