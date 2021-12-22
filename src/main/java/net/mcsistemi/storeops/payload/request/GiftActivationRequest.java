package net.mcsistemi.storeops.payload.request;

public class GiftActivationRequest {

    private String idstore;
    private String gnumber;
    private Double gamount;
    private String codrec;

    public GiftActivationRequest() {
    }

    public GiftActivationRequest(String idstore, String gnumber, Double gamount, String codrec) {
        this.idstore = idstore;
        this.gnumber = gnumber;
        this.gamount = gamount;
        this.codrec = codrec;
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

    public Double getGamount() {
        return gamount;
    }

    public void setGamount(Double gamount) {
        this.gamount = gamount;
    }

    public String getCodrec() {
        return codrec;
    }

    public void setCodrec(String codrec) {
        this.codrec = codrec;
    }
}
