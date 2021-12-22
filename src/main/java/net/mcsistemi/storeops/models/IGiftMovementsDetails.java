package net.mcsistemi.storeops.models;

import java.util.Date;

public interface IGiftMovementsDetails {

    String getId_client();
    String getGift_number();
    String getDescription();
    Date getIssue_date();
    Date getExpiration_date();
    Date getLastop_date();
    Double getInitial_amount();
    Double getCurrent_amount();
    String getStatus_description();
    String getType();
    String getCodrec();

}
