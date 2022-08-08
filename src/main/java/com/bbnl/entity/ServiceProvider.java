package com.bbnl.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="service_provider")
public class ServiceProvider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sp_id")
	private Long spId;

	@Column(name = "sp_name", length = 250)
	private String spName;

	@OneToOne(targetEntity = ServiceType.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "service_type")
	private ServiceType serviceType;

	@Column(name = "authorized_signatory", length = 250)
	private String authorizedSignatory;

	@Column(name = "signatory_aadhar_no", length = 12)
	private String signatoryAadharNo;

	@Column(name = "pan", length = 10)
	private String pan;

	@Column(name = "license_no", length = 100)
	private String licenseNo;

	@Column(name = "tan", length = 10)
	private String tan;

	@Column(name = "gst", length = 15)
	private String gst;

	@Column(name = "ill_required")
	private boolean illRequired;

	@OneToOne(targetEntity = State.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "service_state")
	private State serviceState;

	
	@OneToOne(targetEntity = District.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "service_district")
	private District serviceDistrict;

	@OneToOne(targetEntity = Block.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "service_block")
	private Block serviceBlock;

	@Column(name = "address_line1", length = 250)
	private String addressLine1;

	@Column(name = "address_line2", length = 250)
	private String addressLine2;

	@OneToOne(targetEntity =State.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "state")
	private State state;

	@OneToOne(targetEntity = District.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "district")
	private District district;

	@Column(name = "email_id", length = 100)
	private String emailId;

	@Column(name = "mobile_no", length = 10)
	private String mobileNo;
	
	@Transient
	@Column(name="main_images")
	private String mainImage;
	
	@OneToMany(mappedBy= "serviceProvider",cascade=CascadeType.ALL)
	private Set<RegisteredDocuments> documentsImages=new HashSet<>();

	public ServiceProvider() {
		super();
	}

	public ServiceProvider(Long spId, String spName, ServiceType serviceType, String authorizedSignatory,
			String signatoryAadharNo, String pan, String licenseNo, String tan, String gst, boolean illRequired,
			State serviceState, District serviceDistrict, Block serviceBlock, String addressLine1, String addressLine2,
			State state, District district, String emailId, String mobileNo) {
		super();
		this.spId = spId;
		this.spName = spName;
		this.serviceType = serviceType;
		this.authorizedSignatory = authorizedSignatory;
		this.signatoryAadharNo = signatoryAadharNo;
		this.pan = pan;
		this.licenseNo = licenseNo;
		this.tan = tan;
		this.gst = gst;
		this.illRequired = illRequired;
		this.serviceState = serviceState;
		this.serviceDistrict = serviceDistrict;
		this.serviceBlock = serviceBlock;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.district = district;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}

	public Long getSpId() {
		return spId;
	}

	public void setSpId(Long spId) {
		this.spId = spId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public String getAuthorizedSignatory() {
		return authorizedSignatory;
	}

	public void setAuthorizedSignatory(String authorizedSignatory) {
		this.authorizedSignatory = authorizedSignatory;
	}

	public String getSignatoryAadharNo() {
		return signatoryAadharNo;
	}

	public void setSignatoryAadharNo(String signatoryAadharNo) {
		this.signatoryAadharNo = signatoryAadharNo;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getTan() {
		return tan;
	}

	public void setTan(String tan) {
		this.tan = tan;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public boolean isIllRequired() {
		return illRequired;
	}

	public void setIllRequired(boolean illRequired) {
		this.illRequired = illRequired;
	}

	public State getServiceState() {
		return serviceState;
	}

	public void setServiceState(State serviceState) {
		this.serviceState = serviceState;
	}

	public District getServiceDistrict() {
		return serviceDistrict;
	}

	public void setServiceDistrict(District serviceDistrict) {
		this.serviceDistrict = serviceDistrict;
	}

	public Block getServiceBlock() {
		return serviceBlock;
	}

	public void setServiceBlock(Block serviceBlock) {
		this.serviceBlock = serviceBlock;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	

	

	/*
	 * @Override public int hashCode() { return Objects.hash(addressLine1,
	 * addressLine2, authorizedSignatory, emailId, gst, illRequired, licenseNo,
	 * mobileNo, pan, signatoryAadharNo, spId, spName, tan); }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; ServiceProvider other = (ServiceProvider) obj; return
	 * Objects.equals(addressLine1, other.addressLine1) &&
	 * Objects.equals(addressLine2, other.addressLine2) &&
	 * Objects.equals(authorizedSignatory, other.authorizedSignatory) &&
	 * Objects.equals(emailId, other.emailId) && Objects.equals(gst, other.gst) &&
	 * illRequired == other.illRequired && Objects.equals(licenseNo,
	 * other.licenseNo) && Objects.equals(mobileNo, other.mobileNo) &&
	 * Objects.equals(pan, other.pan) && Objects.equals(signatoryAadharNo,
	 * other.signatoryAadharNo) && Objects.equals(spId, other.spId) &&
	 * Objects.equals(spName, other.spName) && Objects.equals(tan, other.tan); }
	 */

	@Override
	public String toString() {
		return "ServiceProvider [spId=" + spId + ", spName=" + spName + ", serviceType=" + serviceType
				+ ", authorizedSignatory=" + authorizedSignatory + ", signatoryAadharNo=" + signatoryAadharNo + ", pan="
				+ pan + ", licenseNo=" + licenseNo + ", tan=" + tan + ", gst=" + gst + ", illRequired=" + illRequired
				+ ", serviceState=" + serviceState + ", serviceDistrict=" + serviceDistrict + ", serviceBlock="
				+ serviceBlock + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", state="
				+ state + ", district=" + district + ", emailId=" + emailId + ", mobileNo=" + mobileNo + "]";
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	
	

	public Set<RegisteredDocuments> getDocumentsImages() {
		return documentsImages;
	}

	public void setDocumentsImages(Set<RegisteredDocuments> documentsImages) {
		this.documentsImages = documentsImages;
	}
	
	
	public void addExtraDocumentsImages(String documentsImagesName) {
		this.documentsImages.add(new RegisteredDocuments(documentsImagesName,this)); 
	}
	
	@Transient
	public String getMainImagePath() {
		 if (spId == null) return null;
		return "/serviceProvider/"+this.spId+"/"+"pan.jpg";
	}

}
