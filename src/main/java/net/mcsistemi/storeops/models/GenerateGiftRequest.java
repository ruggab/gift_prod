package net.mcsistemi.storeops.models;

public class GenerateGiftRequest {

    private Integer gift_qta;
    private String gift_language;

    public GenerateGiftRequest(){

    }

    public GenerateGiftRequest(Integer gift_qta, String gift_language) {
        this.gift_qta = gift_qta;
        this.gift_language = gift_language;
    }

    public Integer getGift_qta() {
        return gift_qta;
    }

    public void setGift_qta(Integer gift_qta) {
        this.gift_qta = gift_qta;
    }

    public String getGift_language() {
        return gift_language;
    }

    public void setGift_language(String gift_language) {
        this.gift_language = gift_language;
    }
}
