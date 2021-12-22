package net.mcsistemi.storeops.models;

import java.util.Date;

public interface IGiftDetails {

    String getId_client();
    String getGift_number();
    String getDescription();
    Date getIssue_date();
    Date getExpiration_date();
    Double getInitial_amount();
    Double getCurrent_amount();
    String getStatus_description();
    String getType();

}
