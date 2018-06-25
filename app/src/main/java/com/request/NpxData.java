
package com.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NpxData {
    public NpxData(String e103, String e201, String e202) {
        this.e103 = e103;
        this.e201 = e201;
        this.e202 = e202;
    }

    @SerializedName("E103")
    @Expose
    private String e103;
    @SerializedName("E201")
    @Expose
    private String e201;
    @SerializedName("E202")
    @Expose
    private String e202;

    public String getE103() {
        return e103;
    }

    public void setE103(String e103) {
        this.e103 = e103;
    }

    public String getE201() {
        return e201;
    }

    public void setE201(String e201) {
        this.e201 = e201;
    }

    public String getE202() {
        return e202;
    }

    public void setE202(String e202) {
        this.e202 = e202;
    }

}
