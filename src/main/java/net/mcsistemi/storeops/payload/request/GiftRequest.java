package net.mcsistemi.storeops.payload.request;

public class GiftRequest {

    private String idstore;
    private String gnumber;

    public GiftRequest() {
    }

    public GiftRequest(String idstore, String gnumber) {
        this.idstore = idstore;
        this.gnumber = gnumber;
    }

    public String getIdstore() {
        return idstore;
    }

    public void setIdstore(String idstore) {
        this.idstore = idstore;
    }

    public String getGnumber() {
        return gnumber;
    }

    public void setGnumber(String gnumber) {
        this.gnumber = gnumber;
    }
}
