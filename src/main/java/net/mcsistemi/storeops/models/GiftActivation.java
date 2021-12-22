package net.mcsistemi.storeops.models;

public class GiftActivation {

    private String esito;
    private String message;

    public GiftActivation() {
    }

    public GiftActivation(String esito, String message) {
        this.esito = esito;
        this.message = message;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
