/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import static java.lang.String.valueOf;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author RXiau6
 */
public class ReceiptDAO {

    private HttpURLConnection conn;

    public List<Receipt> getAllRecipts(String Account) {

        List<Receipt> acc_receipt = new ArrayList();

        try {

            String url = String.format("http://mbeutwen.ddns.net:8000/api/receipts?"
                    + "limit=0&carrier=%s", Account);
            URL connUrl = new URL(url);
            conn = (HttpURLConnection) connUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

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
                Receipt receipt = new Receipt();
                receipt.setNumber(obj.get("number").toString());
                receipt.setSeller_id(obj.get("seller_id").toString());
                receipt.setDetail(obj.get("detail").toString());
                receipt.setUniform_num(obj.get("uniform_num").toString());
                receipt.setCarrier(obj.get("carrier").toString());
                receipt.setAmount(Double.parseDouble(valueOf(obj.get("amount"))));
                receipt.setCreatedDate(obj.get("created_at").toString());
                receipt.setUpdatedDate(obj.get("updated_at").toString());
                acc_receipt.add(receipt);
            }
            //conn.disconnect();

        } catch (MalformedURLException ex) {
            System.out.println("url異常: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("conn異常: " + ex.toString());
        } catch (JSONException ex) {
            System.out.println("json轉換異常 : " + ex.toString());
        } catch (Exception ex) {
            System.out.println("不明錯誤 : " + ex.toString());
        }

        return acc_receipt;
    }

    public boolean insert(Receipt receipt) {
        boolean success = false;
        try {

            String url = String.format("http://mbeutwen.ddns.net:8000/api/receipts");
            URL connUrl = new URL(url);
            conn = (HttpURLConnection) connUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            //JSON字串處理
            JSONObject receiptJson = new JSONObject(receipt);
            String body = receiptJson.toString();
            OutputStream os = conn.getOutputStream();
            byte[] input = body.getBytes("utf-8");
            os.write(input, 0, input.length);
            success = true;

            //conn.disconnect();
        } catch (MalformedURLException ex) {
            System.out.println("url異常: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("conn異常: " + ex.toString());
        } catch (JSONException ex) {
            System.out.println("json轉換異常 : " + ex.toString());
        } catch (Exception ex) {
            System.out.println("不明錯誤 : " + ex.toString());
        }
        return success;
    }

    public boolean delete(String recipt_num) {

        boolean sucess = false;
        try {
            String url = String.format("http://mbeutwen.ddns.net:8000/api/receipts/%s");
            URL connUrl = new URL(url);
            conn = (HttpURLConnection) connUrl.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            
            sucess = statement.executeUpdate() > 0;
            if (sucess) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("Record not found.");
            }
        } catch (SQLException ex) {
            System.out.println("delete異常:\n" + ex.toString());
        }
        return sucess;
    }

    public static void main(String[] args) {
        ReceiptDAO dao = new ReceiptDAO();
        Receipt recipt = new Receipt("/1**OJHQ", "NF80566859", 100.0, "TWD");
        List<Receipt> acc_recipt = dao.getAllRecipts("/1S**JHQ");
        System.out.println(dao.insert(recipt));
        //System.out.println(dao.delete("NF80566859"));
        for (Receipt my_recipt : acc_recipt) {
            System.out.println(my_recipt);
        }
    }
}
