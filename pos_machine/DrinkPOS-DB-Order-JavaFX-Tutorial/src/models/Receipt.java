/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author RXiau6
 */
public class Receipt {
    private String track;

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
    private String number;
    private String seller_id;
    private String detail;
    private String uniform_num;
    private String carrier;

    public Receipt(String track, String number, String seller_id, String detail,
            String uniform_num, String carrier, double amount) {
        this.track = track;
        this.number = number;
        this.seller_id = seller_id;
        this.detail = detail;
        this.uniform_num = uniform_num;
        this.carrier = carrier;
        this.amount = amount;
    }
    private double amount;
    private String createdDate;
    private String updatedDate;



    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Receipt() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getUniform_num() {
        return uniform_num;
    }

    public void setUniform_num(String uniform_num) {
        this.uniform_num = uniform_num;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
