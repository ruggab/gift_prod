package net.mcsistemi.storeops.models;

import java.util.Date;

public class GiftStatusRequest {

    private String negozio;
    private Date from_date;
    private Date to_date;
    private String status;
    private String type;
    private String gnumber;

    public GiftStatusRequest() {
    }

    public GiftStatusRequest(String negozio, Date from_date, Date to_date, String status, String type, String gnumber) {
        this.negozio = negozio;
        this.from_date = from_date;
        this.to_date = to_date;
        this.status = status;
        this.type = type;
        this.gnumber = gnumber;
    }

    public String getNegozio() {
        return negozio;
    }

    public void setNegozio(String negozio) {
        this.negozio = negozio;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGnumber() {
        return gnumber;
    }

    public void setGnumber(String gnumber) {
        this.gnumber = gnumber;
    }
}
