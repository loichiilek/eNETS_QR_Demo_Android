
package com.request;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestBody {
    public RequestBody(
            String mti,
            String processCode,
            String amount,
            String stan,
            String transactionTime,
            String transactionDate,
            String entryMode,
            String conditionCode,
            String institutionCode,
            String hostTid,
            String hostMid,
            NpxData npxData,
            List<CommunicationDatum> communicationData,
            String getQRCode)
    {
        this.mti = mti;
        this.processCode = processCode;
        this.amount = amount;
        this.stan = stan;
        this.transactionTime = transactionTime;
        this.transactionDate = transactionDate;
        this.entryMode = entryMode;
        this.conditionCode = conditionCode;
        this.institutionCode = institutionCode;
        this.hostTid = hostTid;
        this.hostMid = hostMid;
        this.npxData = npxData;
        this.communicationData = communicationData;
        this.getQRCode = getQRCode;
    }

    @SerializedName("mti")
    @Expose
    private String mti;
    @SerializedName("process_code")
    @Expose
    private String processCode;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("stan")
    @Expose
    private String stan;
    @SerializedName("transaction_time")
    @Expose
    private String transactionTime;
    @SerializedName("transaction_date")
    @Expose
    private String transactionDate;
    @SerializedName("entry_mode")
    @Expose
    private String entryMode;
    @SerializedName("condition_code")
    @Expose
    private String conditionCode;
    @SerializedName("institution_code")
    @Expose
    private String institutionCode;
    @SerializedName("host_tid")
    @Expose
    private String hostTid;
    @SerializedName("host_mid")
    @Expose
    private String hostMid;
    @SerializedName("npx_data")
    @Expose
    private NpxData npxData;
    @SerializedName("communication_data")
    @Expose
    private List<CommunicationDatum> communicationData = null;
    @SerializedName("getQRCode")
    @Expose
    private String getQRCode;

    public String getMti() {
        return mti;
    }

    public void setMti(String mti) {
        this.mti = mti;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getEntryMode() {
        return entryMode;
    }

    public void setEntryMode(String entryMode) {
        this.entryMode = entryMode;
    }

    public String getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(String conditionCode) {
        this.conditionCode = conditionCode;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getHostTid() {
        return hostTid;
    }

    public void setHostTid(String hostTid) {
        this.hostTid = hostTid;
    }

    public String getHostMid() {
        return hostMid;
    }

    public void setHostMid(String hostMid) {
        this.hostMid = hostMid;
    }

    public NpxData getNpxData() {
        return npxData;
    }

    public void setNpxData(NpxData npxData) {
        this.npxData = npxData;
    }

    public List<CommunicationDatum> getCommunicationData() {
        return communicationData;
    }

    public void setCommunicationData(List<CommunicationDatum> communicationData) {
        this.communicationData = communicationData;
    }

    public String getGetQRCode() {
        return getQRCode;
    }

    public void setGetQRCode(String getQRCode) {
        this.getQRCode = getQRCode;
    }

}
