package net.mcsistemi.storeops.models;

public class GiftCheckValue {

    private String status;
    private String esito;
    private Double valore;

    public GiftCheckValue() {
    }

    public GiftCheckValue(String status, String esito, Double valore) {
        this.status = status;
        this.esito = esito;
        this.valore = valore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public Double getValore() {
        return valore;
    }

    public void setValore(Double valore) {
        this.valore = valore;
    }
}
