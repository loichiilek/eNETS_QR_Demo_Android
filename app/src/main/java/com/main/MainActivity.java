package com.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nets_qr_api.NETSQRCallback;
import com.nets_qr_api.NETS_QR_APIController;
import com.request.Addon;
import com.request.CommunicationDatum;
import com.request.NpxData;
import com.request.RequestBody;
import com.response.ResponseBody;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String SECRET_KEY = "21296dd3-5bf6-4dfc-b8a2-03fbcc213b7b";
    private static final int REQUEST_CODE = 1;

    private TextView dollarSign;
    private EditText paymentValue;
    private Button makePayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dollarSign = findViewById(R.id.Dollar);
        makePayment = findViewById(R.id.MakePayment);

        paymentValue = findViewById(R.id.PaymentValue);

        // To disable button if textfield is empty.
        paymentValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(s.toString().trim().length()==0){
                    makePayment.setEnabled(false);
                    dollarSign.setVisibility(View.INVISIBLE);
                } else {
                    makePayment.setEnabled(true);
                    dollarSign.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        paymentValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                boolean isSuccess = data.getBooleanExtra("com.nets.enets.view.extra.TXN_STATUS", false);
                if (isSuccess) {
                    Toast.makeText(MainActivity.this, "Payment Success", Toast.LENGTH_LONG).show();
                }
                else {
                    final String errorCode = data.getStringExtra("com.nets.enets.view.extra.ERROR_CODE");
                    Toast.makeText(MainActivity.this, "Payment Failure " + errorCode, Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    public static RequestBody createPayload(String payment_amount){
        Addon addon = new Addon("8bc63cde-2647-4a78-ac75-d5f534b56047");

        CommunicationDatum communicationDatum = new CommunicationDatum("http", "URL", "https://your-domainname:8801/demo/order/notification", addon);
        List<CommunicationDatum> communicationDatumList = new ArrayList<>();
        communicationDatumList.add(communicationDatum);

        NpxData npxData = new NpxData("99998888","00000123","SGD");

        // Format datetime
        Date date = new Date();
        @SuppressLint("DefaultLocale") String transaction_time = String.format("%02d%02d%02d", date.getHours(), date.getMinutes(), date.getSeconds());
        @SuppressLint("DefaultLocale") String transaction_date = String.format("%02d%02d", date.getMonth()+1, date.getDate());

        payment_amount = formatPaymentAmount(payment_amount);


        return new RequestBody(
                "0200",
                "990000",
                payment_amount,
                "100001",
                transaction_time,
                transaction_date,
                "000",
                "85",
                "20000000001",
                "37066801",
                "11137066800",
                npxData,
                communicationDatumList,
                "Y"
        );
    }

    public void StartPayment(View view) {
        NETS_QR_APIController nets_qr_apiController = new NETS_QR_APIController();
        RequestBody requestBody = createPayload(paymentValue.getText().toString());

        Gson gson = new Gson();
        String request = gson.toJson(requestBody);
        String signature = SignatureGenerator.generateSignature(request, SECRET_KEY);

        nets_qr_apiController.makecall(requestBody, signature, new NETSQRCallback() {
            @Override
            public void onSuccess(ResponseBody responseBody) {
                Log.d("onSuccess", responseBody.getQrCode());
                Bundle qrDataBundle = new Bundle();

                qrDataBundle.putString("com.nets.netspay.intent.extra.QR_DATA", responseBody.getTxnIdentifier());

                Intent intent = new Intent();
                intent.setAction("com.nets.netspay.action.BILL_PAY");
                intent.putExtra("com.nets.netspay.intent.extra.MERCHANT_APP", true);
                intent.putExtras(qrDataBundle);
                startActivityForResult(intent, REQUEST_CODE);
            }

            @Override
            public void onFailure() {
                Log.d("onFailure", "Failed");
            }
        });
    }

    private static String formatPaymentAmount (String payment_amount) {
        if (payment_amount.contains(".")) {

            if (payment_amount.length() - 1 == payment_amount.indexOf(".")) {
                payment_amount = payment_amount.replace(".", "");
                payment_amount = payment_amount + "00";
            } else if (payment_amount.length() - payment_amount.indexOf(".") == 2) {
                payment_amount = payment_amount.replace(".", "");
                payment_amount = payment_amount + "0";
            } else {
                payment_amount = payment_amount.substring(0, payment_amount.indexOf(".") + 3);
                payment_amount = payment_amount.replace(".", "");
            }
        } else {
            payment_amount = payment_amount + "00";
        }

        Log.d("Payment Amount (in cents)", payment_amount);
        return payment_amount;
    }
}
