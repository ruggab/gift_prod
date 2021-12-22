package net.mcsistemi.storeops.models;

public class UpdateGiftRequest {

    private Long qta;

    public UpdateGiftRequest() {
    }

    public UpdateGiftRequest(Long qta) {
        this.qta = qta;
    }

    public Long getQta() {
        return qta;
    }

    public void setQta(Long qta) {
        this.qta = qta;
    }
}
