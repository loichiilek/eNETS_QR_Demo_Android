package com.util;

import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by chiilek on 22/6/2018.
 */

public class SignatureGenerator {
    public static String generateSignature(String payload, String secretKey){
        String concatPayloadAndSecretKey = payload + secretKey;
        byte[] hashed = hashSHA256ToBytes(concatPayloadAndSecretKey.getBytes());
        String signature = encodeBase64(hashed);
        Log.d("Signature", "Signature: " + signature);
        return signature.replace("\n", "");
    }

    private static byte[] hashSHA256ToBytes(byte[] input){
        byte[] byteData;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(input);
            byteData = md.digest();
            Log.d("hashSHA256ToBytes", Arrays.toString(byteData));
            return byteData;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String encodeBase64(byte[] data){


        Log.d("encodeBase64", Base64.encodeToString(data, Base64.DEFAULT));
        return Base64.encodeToString(data, Base64.DEFAULT);

    }
}
