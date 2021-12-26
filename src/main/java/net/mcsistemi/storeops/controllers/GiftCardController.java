package net.mcsistemi.storeops.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.mcsistemi.storeops.models.AssignGiftRequest;
import net.mcsistemi.storeops.models.CouponActivation;
import net.mcsistemi.storeops.models.GenerateGiftRequest;
import net.mcsistemi.storeops.models.GiftActivation;
import net.mcsistemi.storeops.models.GiftAvailability;
import net.mcsistemi.storeops.models.GiftCheckValue;
import net.mcsistemi.storeops.models.GiftMovement;
import net.mcsistemi.storeops.models.GiftStatusRequest;
import net.mcsistemi.storeops.models.IExportGift;
import net.mcsistemi.storeops.models.IGenerateGiftResponse;
import net.mcsistemi.storeops.models.IGiftDaAttivare;
import net.mcsistemi.storeops.models.IGiftDetails;
import net.mcsistemi.storeops.models.IGiftDocument;
import net.mcsistemi.storeops.models.IGiftDocumentDetails;
import net.mcsistemi.storeops.models.IGiftMovementsDetails;
import net.mcsistemi.storeops.models.IGiftToAssign;
import net.mcsistemi.storeops.models.IGrafici;
import net.mcsistemi.storeops.models.IHistogramGraph;
import net.mcsistemi.storeops.models.INegozi;
import net.mcsistemi.storeops.models.UpdateGiftRequest;
import net.mcsistemi.storeops.payload.request.CouponRequest;
import net.mcsistemi.storeops.payload.request.GiftActivationRequest;
import net.mcsistemi.storeops.payload.request.GiftRequest;
import net.mcsistemi.storeops.security.services.GiftCardServiceImpl;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/giftcard/")
public class GiftCardController {

    @Autowired
    GiftCardServiceImpl cardService;

    @PostMapping("check-gift-availability")
    @ResponseBody
    public ResponseEntity<GiftAvailability> checkGiftAvailability(@RequestBody GiftRequest giftRequest){
        GiftAvailability giftAv = cardService.callGiftAvailability(giftRequest.getIdstore(), giftRequest.getGnumber());
        return new ResponseEntity<GiftAvailability>(giftAv, HttpStatus.OK);
    }

    @PostMapping("gift-activation")
    @ResponseBody
    public ResponseEntity<GiftActivation> giftActivation(@RequestBody GiftActivationRequest giftActRequest){
        GiftActivation giftAct = cardService.giftActivation(giftActRequest.getIdstore(), giftActRequest.getGnumber(), giftActRequest.getGamount(), giftActRequest.getCodrec());
        return new ResponseEntity<GiftActivation>(giftAct, HttpStatus.OK);
    }

    @PostMapping("check-gift-value")
    @ResponseBody
    public ResponseEntity<GiftCheckValue> checkGiftValue(@RequestBody GiftRequest giftRequest){
        GiftCheckValue giftCheckValue = cardService.checkGiftValue(giftRequest.getIdstore(), giftRequest.getGnumber());
        return new ResponseEntity<GiftCheckValue>(giftCheckValue, HttpStatus.OK);
    }

    @PostMapping("gift-movement")
    @ResponseBody
    public ResponseEntity<GiftMovement> giftMovement(@RequestBody GiftActivationRequest giftActRequest){
        GiftMovement giftMov = cardService.giftMovement(giftActRequest.getIdstore(), giftActRequest.getGnumber(), giftActRequest.getGamount(), giftActRequest.getCodrec());
        return new ResponseEntity<GiftMovement>(giftMov, HttpStatus.OK);
    }

    @PostMapping("coupon-activation")
    @ResponseBody
    public ResponseEntity<CouponActivation> couponActivation(@RequestBody CouponRequest couponRequest){
        CouponActivation couponAct = cardService.couponActivation(couponRequest.getIdstore(), couponRequest.getGamount(), couponRequest.getCodrec());
        return new ResponseEntity<CouponActivation>(couponAct, HttpStatus.OK);
    }

    @PostMapping("gift-generate-new-code")
    @ResponseBody
    public ResponseEntity<String> generateGiftCode(@RequestBody String idStore){
        String giftEan = cardService.getGiftBuonoEan(idStore);
        return new ResponseEntity<String>(giftEan, HttpStatus.OK);
    }

    @GetMapping("getlistanegozi")
    public ResponseEntity<List<INegozi>> getListaNegozi(){
        List<INegozi> listaNegozi = cardService.getListaNegozi();
        return new ResponseEntity<List<INegozi>>(listaNegozi, HttpStatus.OK);
    }

    @GetMapping("getlistastatus")
    public ResponseEntity<List<String>> getListaStatus() {
        List<String> listaStatus = cardService.getAllStatus();
        return new ResponseEntity<List<String>>(listaStatus, HttpStatus.OK);
    }

    @PostMapping("getallgiftbycustomfilter")
    @ResponseBody
    public ResponseEntity<List<IGiftDetails>> getAllGiftByCustomFilter(@RequestBody GiftStatusRequest giftStatusRequest){
        List<IGiftDetails> listaGift = cardService.getAllGiftByCustomFilter(giftStatusRequest);
        return new ResponseEntity<List<IGiftDetails>>(listaGift, HttpStatus.OK);
    }

    @PostMapping("getgiftbygnumber")
    @ResponseBody
    public ResponseEntity<List<IGiftDetails>> getGiftByGNumber(@RequestBody String gnumber){
        List<IGiftDetails> dettaglioGift = cardService.getGiftByGNumber(gnumber);
        return new ResponseEntity<List<IGiftDetails>>(dettaglioGift, HttpStatus.OK);
    }

    @PostMapping("getgiftmovementsbygnumber")
    @ResponseBody
    public ResponseEntity<List<IGiftMovementsDetails>> getGiftMovementsByGiftNumber(@RequestBody String gnumber){
        List<IGiftMovementsDetails> dettaglioMovimenti = cardService.getGiftMovementsByGnumber(gnumber);
        return new ResponseEntity<List<IGiftMovementsDetails>>(dettaglioMovimenti, HttpStatus.OK);
    }

    @GetMapping("getgiftdaattivare/{id_client}")
    public ResponseEntity<List<IGiftDaAttivare>> getGiftDaAttivare(@PathVariable("id_client") String id_client){
        List<IGiftDaAttivare> listaGiftDaAttivare = cardService.getGiftDaAttivare(id_client);
        return new ResponseEntity<List<IGiftDaAttivare>>(listaGiftDaAttivare, HttpStatus.OK);
    }

    @GetMapping("getlanguages")
    public ResponseEntity<List<String>> getLanguages(){
        List<String> listaLingue = cardService.getLanguages();
        return new ResponseEntity<List<String>>(listaLingue, HttpStatus.OK);
    }

    @PostMapping("generategift")
    @ResponseBody
    public ResponseEntity<IGenerateGiftResponse> generateGift(@RequestBody GenerateGiftRequest generateGiftRequest){
        IGenerateGiftResponse generateGiftResponse = cardService.generateGift(generateGiftRequest);
        return new ResponseEntity<IGenerateGiftResponse>(generateGiftResponse, HttpStatus.OK);
    }

    @GetMapping("getdocuments")
    public ResponseEntity<List<IGiftDocument>> getdocuments(){
        List<IGiftDocument> listaDocumenti = cardService.getDocuments();
        return new ResponseEntity<List<IGiftDocument>>(listaDocumenti, HttpStatus.OK);
    }

    @GetMapping("getdocumentsdetails/{id_document}")
    public ResponseEntity<List<IGiftDocumentDetails>> getDocumentsDetails(@PathVariable("id_document") Long id_document){
        List<IGiftDocumentDetails> listaDocumentDetails = cardService.getDocumentDetails(id_document);
        return new ResponseEntity<List<IGiftDocumentDetails>>(listaDocumentDetails, HttpStatus.OK);
    }

    @GetMapping("getgifttoassign")
    public ResponseEntity<List<IGiftToAssign>> getGiftToAssign(){
        List<IGiftToAssign> giftDaAssegnare = cardService.getGiftToAssign();
        return new ResponseEntity<List<IGiftToAssign>>(giftDaAssegnare, HttpStatus.OK);
    }

    @PostMapping(value = "assigngift")
    @ResponseBody
    public void assignGift(@RequestBody AssignGiftRequest assignGiftRequest){
        cardService.assignGift(assignGiftRequest);
        //return new ResponseEntity<String>(res, HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "updatelotsize")
    @ResponseBody
    public void updateLotSize(@RequestBody UpdateGiftRequest u){
        cardService.updateLotSize(u.getQta());
        //return new ResponseEntity<String>(res, HttpStatus.OK);
    }

    @GetMapping("getlotsize")
    public ResponseEntity<Long> getLotSize(){
        Long lotSize = cardService.getLotSize();
        return new ResponseEntity<Long>(lotSize, HttpStatus.OK);
    }

    @GetMapping("getgifttoexport/{id_document}")
    public ResponseEntity<List<IExportGift>> getGiftToExport(@PathVariable("id_document") Long id_document){
        List<IExportGift> giftToExport = cardService.getGiftToExport(id_document);
        return new ResponseEntity<List<IExportGift>>(giftToExport, HttpStatus.OK);
    }

    @GetMapping("getHistogram/{year}/{month}")
    public ResponseEntity<List<IHistogramGraph>> getHistogram(@PathVariable("year") String year, @PathVariable("month") String month){
        List<IHistogramGraph> histogram = cardService.getHistogram(year, month);
        return new ResponseEntity<List<IHistogramGraph>>(histogram, HttpStatus.OK);
    }

    @GetMapping("getGrafici/{year}/{month}")
    public ResponseEntity<List<IGrafici>> getGrafici(@PathVariable("year") String year, @PathVariable("month") String month){
        List<IGrafici> grafici = cardService.getGrafici(year, month);
        return new ResponseEntity<List<IGrafici>>(grafici, HttpStatus.OK);
    }


}
