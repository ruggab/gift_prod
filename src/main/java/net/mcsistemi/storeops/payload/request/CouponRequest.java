package net.mcsistemi.storeops.payload.request;

public class CouponRequest {

    private String idstore;
    private Double gamount;
    private String codrec;

    public CouponRequest() {
    }

    public CouponRequest(String idstore, Double gamount, String codrec) {
        this.idstore = idstore;
        this.gamount = gamount;
        this.codrec = codrec;
    }

    public String getIdstore() {
        return idstore;
    }

    public void setIdstore(String idstore) {
        this.idstore = idstore;
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
