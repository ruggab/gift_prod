package net.mcsistemi.storeops.controllers;

import net.mcsistemi.storeops.models.GiftCheckView;
import net.mcsistemi.storeops.security.services.GiftCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
public class HtmlController {

    @Autowired
    GiftCardServiceImpl giftCardService;

    @GetMapping("/giftview/{gnumber}")
    public String checkGiftView(@PathVariable("gnumber") String gnumber, Model model){

        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        GiftCheckView giftCheckView = giftCardService.giftCheckView(gnumber);

        if (giftCheckView != null) {

            String saldo = String.format("%.2f", giftCheckView.getSaldo());

            model.addAttribute("gnumber", giftCheckView.getGnumber());
            model.addAttribute("expiration_date", df.format(giftCheckView.getExpiration_date()));
            model.addAttribute("saldo", saldo);

            return "checkGift";
        }

        else {
            model.addAttribute("gnumber", "Gift not found");
            model.addAttribute("expiration_date", "Gift not found");
            model.addAttribute("saldo", "Gift not found");

            return "checkGift";
        }

    }

}
