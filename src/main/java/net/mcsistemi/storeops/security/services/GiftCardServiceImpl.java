package net.mcsistemi.storeops.security.services;

import net.mcsistemi.storeops.models.*;
import net.mcsistemi.storeops.repository.GiftCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftCardServiceImpl {

    @Autowired
    GiftCardRepository giftCardRepository;

    public boolean checkDbConnection(){

        Integer check = giftCardRepository.checkDbConn();

        if (check == 1){
            return true;
        }

        return false;
    }

    public GiftAvailability callGiftAvailability(String idstore, String gnumber){
        GiftAvailability giftAv = new GiftAvailability();
        ICheckGiftAvailability IgiftAv = giftCardRepository.check_gift_availability(idstore, gnumber);
        giftAv.setEsito(IgiftAv.getEsito());
        giftAv.setMessage(IgiftAv.getMessage());

        return giftAv;
    }

    public GiftActivation giftActivation(String idstore, String gnumber, Double gamount, String codrec){
        GiftActivation giftAct = new GiftActivation();
        IGiftActivation IgiftActv = giftCardRepository.gift_activation(idstore, gnumber, gamount, codrec);
        giftAct.setEsito(IgiftActv.getEsito_actv());
        giftAct.setMessage(IgiftActv.getMessage_actv());

        return giftAct;
    }

    public GiftCheckValue checkGiftValue(String idstore, String gnumber){
        GiftCheckValue giftValue = new GiftCheckValue();
        ICheckGiftValue IgiftValue = giftCardRepository.gift_check_value(idstore, gnumber);
        giftValue.setStatus(IgiftValue.getStatus_chkv());
        giftValue.setEsito(IgiftValue.getEsito_chkv());
        giftValue.setValore(IgiftValue.getValore_chkv());

        return giftValue;
    }

    public GiftMovement giftMovement(String idstore, String gnumber, Double gamount, String codrec){
        GiftMovement giftMov = new GiftMovement();
        IGiftMovement IgiftMov = giftCardRepository.gift_movement(idstore, gnumber, gamount, codrec);
        giftMov.setEsito_mov(IgiftMov.getEsito_mov());
        giftMov.setMessage_mov(IgiftMov.getMessage_mov());
        giftMov.setValore_mov(IgiftMov.getValore_mov());

        return giftMov;
    }

    public CouponActivation couponActivation(String idstore, Double gamount, String codrec){
        CouponActivation couponAct = new CouponActivation();
        ICouponActivation IcouponAct = giftCardRepository.coupon_activation(idstore, gamount, codrec);
        couponAct.setEsito_actc(IcouponAct.getEsito_actc());
        couponAct.setMessage_actc(IcouponAct.getMessage_actc());
        couponAct.setEan_actc(IcouponAct.getEan_actc());

        return couponAct;

    }

    public GiftCheckView giftCheckView(String gnumber){
        GiftCheckView giftCheckView = new GiftCheckView();
        IGiftCheckView iGiftCheckView = giftCardRepository.gift_check_view(gnumber);
        if(iGiftCheckView != null) {
            giftCheckView.setGnumber(iGiftCheckView.getGift_number());
            giftCheckView.setExpiration_date(iGiftCheckView.getExpiration_date());
            giftCheckView.setSaldo(iGiftCheckView.getSaldo());

            return giftCheckView;
        }
        else {
            return null;
        }
    }

    public String getGiftBuonoEan(String idStore){
        String eanGift = giftCardRepository.gift_generate_newcode(idStore);
        return eanGift;
    }


    public List<INegozi> getListaNegozi() {
        return giftCardRepository.getAllNegozi();
    }

    public List<String> getAllStatus() {
        return giftCardRepository.getAllGiftStatus();
    }

    public List<IGiftDetails> getAllGiftByCustomFilter(GiftStatusRequest g) {
        List<IGiftDetails> listaGift = giftCardRepository.getAllGiftByCustomFilter(g.getNegozio(),g.getFrom_date(),g.getTo_date(),g.getStatus(),g.getType());
        return listaGift;
    }

    public List<IGiftDetails> getGiftByGNumber(String gnumber) {
        return giftCardRepository.getDetailsByGiftNumber(gnumber);
    }

    public List<IGiftMovementsDetails> getGiftMovementsByGnumber(String gnumber) {
        return giftCardRepository.getGiftMovementsDetailsByGnumber(gnumber);
    }

    public List<IGiftDaAttivare> getGiftDaAttivare(String id_client) {
        return giftCardRepository.getGiftDaAttivare(id_client);
    }

    public List<String> getLanguages(){
        return giftCardRepository.getLanguages();
    }

    public IGenerateGiftResponse generateGift(GenerateGiftRequest generateGiftRequest) {
        return giftCardRepository.generateGift(generateGiftRequest.getGift_qta(), generateGiftRequest.getGift_language());
    }

    public List<IGiftDocument> getDocuments() {
        return giftCardRepository.getDocuments();
    }

    public List<IGiftDocumentDetails> getDocumentDetails(Long id_document) {
        return giftCardRepository.getDocumentDetails(id_document);
    }

    public List<IGiftToAssign> getGiftToAssign() {
        return giftCardRepository.getGiftToAssign();
    }

    public String assignGift(AssignGiftRequest assignGiftRequest) {
        return giftCardRepository.assignGift(assignGiftRequest.getPackage_no(), assignGiftRequest.getIdstore());
    }

    public String updateLotSize(Long lotSize) {
        giftCardRepository.updateLotSize(lotSize);
        return "OK";
    }

    public Long getLotSize() {
        return giftCardRepository.getLotSize();
    }

    public List<IExportGift> getGiftToExport(Long id_document) {
        return giftCardRepository.getGiftToExport(id_document);
    }

    public List<IHistogramGraph> getHistogram(String year, String month) {
        return giftCardRepository.getHistogram(year, month);
    }

    public List<IGrafici> getGrafici(String year, String month) {
        return giftCardRepository.getGrafici(year, month);
    }
}
