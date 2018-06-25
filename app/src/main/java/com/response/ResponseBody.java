
package com.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseBody {

    @SerializedName("mti")
    @Expose
    private String mti;
    @SerializedName("txn_identifier")
    @Expose
    private String txnIdentifier;
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
    @SerializedName("response_code")
    @Expose
    private String responseCode;
    @SerializedName("host_tid")
    @Expose
    private String hostTid;
    @SerializedName("qr_code")
    @Expose
    private String qrCode;
    @SerializedName("request_received_time")
    @Expose
    private Integer requestReceivedTime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseBody() {
    }

    /**
     * 
     * @param entryMode
     * @param amount
     * @param responseCode
     * @param conditionCode
     * @param processCode
     * @param institutionCode
     * @param transactionTime
     * @param stan
     * @param qrCode
     * @param requestReceivedTime
     * @param hostTid
     * @param mti
     * @param transactionDate
     * @param txnIdentifier
     */
    public ResponseBody(String mti, String txnIdentifier, String processCode, String amount, String stan, String transactionTime, String transactionDate, String entryMode, String conditionCode, String institutionCode, String responseCode, String hostTid, String qrCode, Integer requestReceivedTime) {
        super();
        this.mti = mti;
        this.txnIdentifier = txnIdentifier;
        this.processCode = processCode;
        this.amount = amount;
        this.stan = stan;
        this.transactionTime = transactionTime;
        this.transactionDate = transactionDate;
        this.entryMode = entryMode;
        this.conditionCode = conditionCode;
        this.institutionCode = institutionCode;
        this.responseCode = responseCode;
        this.hostTid = hostTid;
        this.qrCode = qrCode;
        this.requestReceivedTime = requestReceivedTime;
    }

    public String getMti() {
        return mti;
    }

    public void setMti(String mti) {
        this.mti = mti;
    }

    public String getTxnIdentifier() {
        return txnIdentifier;
    }

    public void setTxnIdentifier(String txnIdentifier) {
        this.txnIdentifier = txnIdentifier;
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

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getHostTid() {
        return hostTid;
    }

    public void setHostTid(String hostTid) {
        this.hostTid = hostTid;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Integer getRequestReceivedTime() {
        return requestReceivedTime;
    }

    public void setRequestReceivedTime(Integer requestReceivedTime) {
        this.requestReceivedTime = requestReceivedTime;
    }

}
