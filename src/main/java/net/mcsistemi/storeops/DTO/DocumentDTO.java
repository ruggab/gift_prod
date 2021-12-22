package net.mcsistemi.storeops.DTO;

public class DocumentDTO {

	private String reference;
	private String vendorCode;
	private String gtin;
	private boolean checknet;
	
	public DocumentDTO () {
	}
	
	public DocumentDTO(String reference, String vendorCode, String gtin, boolean checknet) {
		this.reference=reference;
		this.vendorCode=vendorCode;
		this.gtin=gtin;
		this.checknet=checknet;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	public boolean isChecknet() {
		return checknet;
	}

	public void setChecknet(boolean checknet) {
		this.checknet = checknet;
	}
	
	
	
	
}
