/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author rxiau6-PC
 */
public class Coupon {
    private String seller_id;
    private String title;
    private String detail;
    private String carrier;
    private String expired_date;
    private int used;

    public Coupon() {
    }

    public Coupon(String seller_id, String title, String detail, String carrier, String expired_date, int used) {
        this.seller_id = seller_id;
        this.title = title;
        this.detail = detail;
        this.carrier = carrier;
        this.expired_date = expired_date;
        this.used = used;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(String expired_date) {
        this.expired_date = expired_date;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }
}
