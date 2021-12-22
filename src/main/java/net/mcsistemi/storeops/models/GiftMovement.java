package net.mcsistemi.storeops.models;

public class GiftMovement {

    private String esito_mov;
    private String message_mov;
    private Double valore_mov;

    public GiftMovement() {
    }

    public GiftMovement(String esito_mov, String message_mov, Double valore_mov) {
        this.esito_mov = esito_mov;
        this.message_mov = message_mov;
        this.valore_mov = valore_mov;
    }

    public String getEsito_mov() {
        return esito_mov;
    }

    public void setEsito_mov(String esito_mov) {
        this.esito_mov = esito_mov;
    }

    public String getMessage_mov() {
        return message_mov;
    }

    public void setMessage_mov(String message_mov) {
        this.message_mov = message_mov;
    }

    public Double getValore_mov() {
        return valore_mov;
    }

    public void setValore_mov(Double valore_mov) {
        this.valore_mov = valore_mov;
    }
}
