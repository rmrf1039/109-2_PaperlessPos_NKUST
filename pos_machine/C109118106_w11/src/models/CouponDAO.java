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

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author RXiau6
 */
public class CouponDAO {

    private HttpURLConnection conn;

    public List<Coupon> selectByTitle(String title) {
        List<Coupon> acc_coupon = new ArrayList();

        try {

            String url = String.format("http://mbeutwen.ddns.net:8000/api/coupons?"
                    + "seller_id=42087420&title=%s", title);
            URL connUrl = new URL(url);
            conn = (HttpURLConnection) connUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            (conn.getInputStream())));
            //JSON字串處理
            JSONObject output;
            output = new JSONObject(br.readLine());
            JSONArray arr = output.getJSONArray("coupons");
            System.out.println(output);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                Coupon coupon = new Coupon();
                coupon.setNum(i + 1);
                coupon.setSeller_id(obj.get("seller_id").toString());
                coupon.setTitle(obj.get("title").toString());
                coupon.setDetail(obj.get("detail").toString());
                coupon.setCarrier(obj.get("carrier").toString());
                coupon.setExpired_date(obj.get("expired_date").toString());
                coupon.setUsed(Integer.parseInt(valueOf(obj.get("used"))));

                acc_coupon.add(coupon);

            }
        } catch (MalformedURLException ex) {
            System.out.println("getByTitle時 url異常: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("getByTitle時 conn異常: " + ex.toString());
        } catch (JSONException ex) {
            System.out.println("getByTitle時 json轉換異常 : " + ex.toString());
        } catch (Exception ex) {
            System.out.println("getByTitle時 不明錯誤 : " + ex.toString());
        }

        return acc_coupon;

    }

    public List<Coupon> selectByCarrier(String carrier) {
        List<Coupon> acc_coupon = new ArrayList();

        try {

            String url = String.format("http://mbeutwen.ddns.net:8000/api/coupons?"
                    + "seller_id=42087420&carrier=%s", carrier);
            URL connUrl = new URL(url);
            conn = (HttpURLConnection) connUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            (conn.getInputStream())));
            //JSON字串處理
            JSONObject output;
            output = new JSONObject(br.readLine());
            JSONArray arr = output.getJSONArray("coupons");
            System.out.println(output);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                Coupon coupon = new Coupon();
                coupon.setNum(i + 1);
                coupon.setSeller_id(obj.get("seller_id").toString());
                coupon.setTitle(obj.get("title").toString());
                coupon.setDetail(obj.get("detail").toString());
                coupon.setCarrier(obj.get("carrier").toString());
                coupon.setExpired_date(obj.get("expired_date").toString());
                coupon.setUsed(Integer.parseInt(valueOf(obj.get("used"))));

                acc_coupon.add(coupon);
            }
            //conn.disconnect();

        } catch (MalformedURLException ex) {
            System.out.println("getByCarrier時 url異常: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("getByCarrier時 conn異常: " + ex.toString());
        } catch (JSONException ex) {
            System.out.println("getByCarrier時 json轉換異常 : " + ex.toString());
        } catch (Exception ex) {
            System.out.println("getByCarrier時 不明錯誤 : " + ex.toString());
        }

        return acc_coupon;
    }

    public List<Coupon> getAllCoupon(String seller_id) {

        List<Coupon> acc_coupon = new ArrayList();

        try {

            String url = String.format("http://mbeutwen.ddns.net:8000/api/coupons?"
                    + "seller_id=%s", seller_id);
            URL connUrl = new URL(url);
            conn = (HttpURLConnection) connUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            (conn.getInputStream())));
            //JSON字串處理
            JSONObject output;
            output = new JSONObject(br.readLine());
            JSONArray arr = output.getJSONArray("coupons");
            System.out.println(output);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                Coupon coupon = new Coupon();
                coupon.setNum(i + 1);
                coupon.setSeller_id(obj.get("seller_id").toString());
                coupon.setTitle(obj.get("title").toString());
                coupon.setDetail(obj.get("detail").toString());
                coupon.setCarrier(obj.get("carrier").toString());
                coupon.setExpired_date(obj.get("expired_date").toString());
                coupon.setUsed(Integer.parseInt(valueOf(obj.get("used"))));

                acc_coupon.add(coupon);
            }
            //conn.disconnect();

        } catch (MalformedURLException ex) {
            System.out.println("getAll時 url異常: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("getAll時 conn異常: " + ex.toString());
        } catch (JSONException ex) {
            System.out.println("getAll時 json轉換異常 : " + ex.toString());
        } catch (Exception ex) {
            System.out.println("getAll時 不明錯誤 : " + ex.toString());
        }

        return acc_coupon;
    }

    public boolean insert(Coupon coupon) {
        boolean success = false;
        try {

            String url = String.format("http://mbeutwen.ddns.net:8000/api/coupons");
            URL connUrl = new URL(url);
            conn = (HttpURLConnection) connUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            //JSON字串處理
            JSONObject couponJson = new JSONObject(coupon);
            String body = couponJson.toString();
            System.out.println("body" + body);
            OutputStream os = conn.getOutputStream();
            byte[] input = body.getBytes("utf-8");
            os.write(input, 0, input.length);
            success = true;

            //conn.disconnect();
            //get response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            //System.out.println(response.toString());

        } catch (MalformedURLException ex) {
            System.out.println("insert coupon時 url異常: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("insert coupon時 conn異常: " + ex.toString());
        } catch (JSONException ex) {
            System.out.println("insert coupon時 json轉換異常 : " + ex.toString());
        } catch (Exception ex) {
            System.out.println("insert coupon時 不明錯誤 : " + ex.toString());
        }
        return success;
    }

    public boolean delete(String number) {

        boolean sucess = false;
        try {
            String url = String.format("http://mbeutwen.ddns.net:8000/api/receipts/%s",
                    number);
            URL connUrl = new URL(url);
            conn = (HttpURLConnection) connUrl.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");

            sucess = conn.getResponseCode() == 204;
            if (sucess) {
                System.out.println("Record deleted successfully.");
            } else if (conn.getResponseCode() == 404) {
                System.out.println("Record not found.");
            } else {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
        } catch (MalformedURLException ex) {
            System.out.println("delete時 url異常: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("delete時 conn異常: " + ex.toString());
        } catch (JSONException ex) {
            System.out.println("delete時 json轉換異常 : " + ex.toString());
        } catch (Exception ex) {
            System.out.println("delete時 不明錯誤 : " + ex.toString());
        }
        return sucess;
    }

    public static void main(String[] args) {
        CouponDAO dao = new CouponDAO();
        Coupon coupon = new Coupon(
                0,
                "42087420",
                "滿百八折",
                "滿百打八折，上限150",
                "",
                "",
                4357
        );
        List<Coupon> acc_coupon = dao.getAllCoupon("42087420");
        //System.out.println(dao.insert(coupon));
        //System.out.println(dao.delete("AA12678912"));
        /*
        for (Receipt my_recipt : acc_coupon) {
            System.out.println(my_recipt);
        }*/
    }
}
