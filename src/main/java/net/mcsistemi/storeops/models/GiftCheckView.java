package net.mcsistemi.storeops.models;

import java.util.Date;

public class GiftCheckView {

    private String gnumber;
    private Date expiration_date;
    private Double saldo;

    public GiftCheckView(){
    }

    public GiftCheckView(String gnumber, Date expiration_date, Double saldo) {
        this.gnumber = gnumber;
        this.expiration_date = expiration_date;
        this.saldo = saldo;
    }

    public String getGnumber() {
        return gnumber;
    }

    public void setGnumber(String gnumber) {
        this.gnumber = gnumber;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
