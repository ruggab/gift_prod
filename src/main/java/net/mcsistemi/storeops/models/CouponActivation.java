package net.mcsistemi.storeops.models;

public class CouponActivation {

    private String esito_actc;
    private String message_actc;
    private String ean_actc;

    public CouponActivation() {
    }

    public CouponActivation(String esito_actc, String message_actc, String ean_actc) {
        this.esito_actc = esito_actc;
        this.message_actc = message_actc;
        this.ean_actc = ean_actc;
    }

    public String getEsito_actc() {
        return esito_actc;
    }

    public void setEsito_actc(String esito_actc) {
        this.esito_actc = esito_actc;
    }

    public String getMessage_actc() {
        return message_actc;
    }

    public void setMessage_actc(String message_actc) {
        this.message_actc = message_actc;
    }

    public String getEan_actc() {
        return ean_actc;
    }

    public void setEan_actc(String ean_actc) {
        this.ean_actc = ean_actc;
    }

}
