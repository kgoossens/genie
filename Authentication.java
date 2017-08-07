/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package withinoctane;

/**
 *
 * @author bruijsez
 */
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.CookieManager;

import java.net.CookiePolicy;

public class Authentication {
   

    private OkHttpClient client;
    private CookieManager cookieManager;

    public Authentication(){
        authenticate();
    }
    
    public OkHttpClient getClient() {
        return client;
    }

    public CookieManager getCookieManager() {
        return cookieManager;
    }

    private void authenticate() {
        try {
            client = new OkHttpClient();
            cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            client.setCookieHandler(cookieManager);

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"client_id\": \"SezensAPI2_j7g2edrd4r1rjhkq9n46m0q4v\", \r\n     \"client_secret\": \"$90b1c32d7c9ba1ddY\",\r\n     \"enable_csrf\": false\r\n}");
            Request request = new Request.Builder()
                    .url("https://mqast001pngx.saas.hpe.com/authentication/sign_in")
                    .post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "d3063671-d3b1-841f-ad8b-f5dbe15ad304")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println(response);

        } catch (IOException e) {
        }
    } 
  
}

