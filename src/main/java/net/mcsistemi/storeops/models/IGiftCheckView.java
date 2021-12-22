package net.mcsistemi.storeops.models;

import java.util.Date;

public interface IGiftCheckView {

    String getGift_number();
    Date getExpiration_date();
    Double getSaldo();

}
