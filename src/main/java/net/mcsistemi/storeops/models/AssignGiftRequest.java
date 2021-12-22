package net.mcsistemi.storeops.models;

public class AssignGiftRequest {

    private String package_no;
    private String idstore;

    public AssignGiftRequest(){

    }

    public AssignGiftRequest(String package_no, String idstore) {
        this.package_no = package_no;
        this.idstore = idstore;
    }

    public String getPackage_no() {
        return package_no;
    }

    public void setPackage_no(String package_no) {
        this.package_no = package_no;
    }

    public String getIdstore() {
        return idstore;
    }

    public void setIdstore(String idstore) {
        this.idstore = idstore;
    }
}
