/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package withinoctane;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.jsoup.Jsoup;

/**
 *
 * @author bruijsez
 */
public class PostStory {

    Response response;
    Authentication authentication;
    GetChanged getchanged = new GetChanged(authentication);
    String story;
    String ownertje;

    public PostStory(Authentication authentication) throws IOException, ParseException {
        //  String storyInput = getchanged.story();
        //  this.story=storyInput;
        this.authentication = new Authentication();

    }

    public String PostStory() throws ParseException, IOException, org.json.simple.parser.ParseException {

        JSONArray getChanged = getchanged.story();

        JSONParser parser = new JSONParser();
        //   Object obj = parser.parse(getChanged);
        JSONArray File2 = (JSONArray) getChanged;
        //  JSONArray data = (JSONArray) File2.get(0);
        JSONObject data2 = (JSONObject) File2.get(0);//loop here
        Object property = data2.get(("name"));
        Object property2 = data2.get(("description"));
        JSONObject property3 = (JSONObject) data2.get(("owner"));
        Object owner2 = data2.get(("id"));
        JSONObject owner9 = (JSONObject) File2.get(0);
        JSONObject owner10 = (JSONObject) owner9.get(("author"));
        //   JSONObject owner8 = (JSONObject) owner10.get("author");
        Object owner7 = owner10.get(("id"));
        Boolean property5 = data2.containsValue(("owner"));

//  JSONObject name = (JSONObject) data2.get(("name"));
        String name = property.toString();
        String description = property2.toString();
        String description2 = Jsoup.parse(description).text();

        //  Object owner2 =owner.getBytes(("id"));
        String ownertje;
        if (!(property5 = false)) {
            ownertje = owner7.toString();
        } else {
            ownertje = property3.toString();
        }

        String owner = ownertje;
        // JSONArray data3 = (JSONArray) data2.get("name");
        String data3 = data2.toString();
        String a = "There has been a change in " + name;
        String b = "The description is: " + description2 + "For further info check with the user with the id" + owner;//+owner;//This one goes bad due to it being multiple elements and somehow I can't navigate..
        OkHttpClient client2 = authentication.getClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\":[{\r\n \"author\":{\r\n \"id\":\"1001\",\r\n \"type\":\"workspace_user\"} \r\n, \"name\":\"" + a + "\",\r\n\"description\":\"" + b + "\",\r\n\"type\":\"story\",\r\n\"parent\":{\r\n\"type\":\"feature\",\r\n\"id\":\"25004\"}\r\n}]} ");
        Request request = new Request.Builder()
                .url("https://mqast001pngx.saas.hpe.com/api/shared_spaces/66002/workspaces/3001/stories")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "7ac0b37f-693d-26bf-6d4f-e8759949c936")
                .build();

        Response response2 = client2.newCall(request).execute();
        System.out.println(response2 + " " + response2.body());
        ResponseBody response3 = response2.body();
        String response4 = response3.toString();
        return owner;
    }
}
