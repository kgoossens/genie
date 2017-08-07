/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package withinoctane;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author bruijsez
 */
public class GetChanged {

    Authentication authentication;

    public GetChanged(Authentication authentication) {
        this.authentication = new Authentication();

    }

    public JSONArray story() throws ParseException {

        try {

            OkHttpClient client;
            client = authentication.getClient();

            Request request = new Request.Builder()
                    .url("https://mqast001pngx.saas.hpe.com/api/shared_spaces/66002/workspaces/1002/stories?fields=owner,author,comments,description,name&query=%22user_tags%20EQ%20%7Bid%20EQ%206001%7D%22")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "dbd09071-da07-2182-e79f-20fd1b992388")
                    .build();

            Response response2 = client.newCall(request).execute();

            String jsonobject = response2.body().string();

//step by step navigating through the file
            String response3 = response2.toString();

//System.out.println(response2.body().string());
            JSONParser parser;
            parser = new JSONParser();
            Object obj = parser.parse(jsonobject);

            JSONObject File2 = (JSONObject) obj;
            //maakt van document een object
            //print object         
            JSONArray data = (JSONArray) File2.get("data");

//step by step navigating through the file
     
            String data2 = data.toString();

            return data; //data2;
        } catch (IOException e) {
        }
        return null;

    }
}
