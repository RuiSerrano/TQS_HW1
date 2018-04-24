/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tqs_hw1_rui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Rui Serrano
 */
public class RateService {

// f84efe469a2dafaefb35664321f00edb
    // essential URL structure is built using constants
    public static final String ACCESS_KEY = "f84efe469a2dafaefb35664321f00edb";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) API
    CloseableHttpClient httpClient;

    public RateService() {
        this.httpClient = HttpClients.createDefault();
    }

    /**
     *
     * Notes:
     *
     * A JSON response of the form {"key":"value"} is considered a simple Java
     * JSONObject. To get a simple value from the JSONObject, use:
     * <JSONObject identifier>.get<Type>("key");
     *
     * A JSON response of the form {"key":{"key":"value"}} is considered a
     * complex Java JSONObject. To get a complex value like another JSONObject,
     * use: <JSONObject identifier>.getJSONObject("key")
     *
     * Values can also be JSONArray Objects. JSONArray objects are simple,
     * consisting of multiple JSONObject Objects.
     *
     * http://apilayer.net/api/live
     *
     * ? access_key = YOUR_ACCESS_KEY & source = GBP & currencies =
     * USD,AUD,CAD,PLN,MXN & format = 1
     */
    public void close() {
        try {
            httpClient.close();
        } catch (IOException ex) {
            Logger.getLogger(RateService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // sendLiveRequest() function is created to request and retrieve the data
    public double getRate(String to) {

        // The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);

        try {
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            // the following line converts the JSON Response to an equivalent Java Object
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
            response.close();
            return exchangeRates.getJSONObject("quotes").getDouble("USD" + to.toUpperCase());
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0; //supposed to never reach here
    }

    private boolean validateCurrencieName(String name) {
        return (name.equals("USD")||name.equals("AUD")||name.equals("CAD")||name.equals("PLN")||name.equals("MXN")||name.equals("EUR"));
    }

    // sendLiveRequest() function is executed

}



//validate currencies = USD,AUD,CAD,PLN,MXN!!!
