/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author rxiau6-PC
 */
public class RESTfulConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            URL url = new URL("http://mbeutwen.ddns.net:8000/api/receipts?limit=0&carrier=/1ZXCASD");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setInstanceFollowRedirects(false);
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            //JSON字串處理
            JSONObject output;
            output = new JSONObject(br.readLine());
            JSONArray arr = output.getJSONArray("receipts");
            System.out.println(output);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                System.out.println(obj.get("number"));
                System.out.println(obj.get("seller_id"));
                System.out.println(obj.get("detail"));
                System.out.println(obj.get("uniform_num"));
                System.out.println(obj.get("carrier"));
                System.out.println(obj.get("amount"));
                System.out.println(obj.get("created_at"));
                System.out.println(obj.get("updated_at"));
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            System.out.println(e);

        } catch (IOException e) {

            System.out.println(e);

        } catch (JSONException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
