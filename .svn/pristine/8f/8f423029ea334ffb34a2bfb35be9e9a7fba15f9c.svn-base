package com.bbnl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crf")
public class CustomerRequestForm {
	@Id
	@Column(name = "crf_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer crfId;
	
	@Column(name = "applicant_name", length = 250)
	private String applicantName;
	
	@Column(name = "applicant_address", length = 250)
	private String applicantAddress;
	
	@Column(name = "applicant_pan", length = 10)
	private String applicantPan;
	
	@Column(name = "bandwidth_required")
	private double bandwidthRequired;
	
	@Column(name = "port_capacity_required")
	private Integer portCapacityRequired;
	
	@Column(name = "legal_status")
	private Integer legalStatus;
	
	@Column(name = "general_information", length = 250)
	private String generalInformation;
	
	private String state;
	private String district;
	private String block;
	private String gp;
	
	@Column(name = "block_contact_name",length = 250)
	private String blockContactName;
	
	@Column(name = "block_contact_designation", length = 100)
	private String blockContactDesignation;
	
	@Column(name = "block_contact_address", length = 250)
	private String blockContactAddress;
	
	@Column(name = "block_contact_mobile", length = 10)
	private String blockContactMobile;
	
	@Column(name = "block_contact_email", length = 100)
	private String blockContactEmail;
	
	@Column(name = "gp_contact_name", length = 250)
	private String gpContactName;
	
	@Column(name = "gp_contact_designation",length = 100)
	private String gpContactDesignation;
	
	@Column(name = "gp_contact_address", length = 250)
	private String gpContactAddress;
	
	@Column(name = "gp_contact_mobile", length = 10)
	private String gpContactMobile;
	
	@Column(name = "gp_contact_email",length = 100)
	private String gpContactEmail;
	
	@Column(name = "contact_name",length = 250)
	private String contactName;
	
	@Column(name = "contact_address", length = 250)
	private String contactAddress;
	
	@Column(name = "contact_mobile", length = 10)
	private String contactMobile;
	
	@Column(name = "contact_email", length = 100)
	private String contactEmail;
	
	@Column(name = "application_date")
	private Date application_date;
	
	@Column(name = "billing_address", length = 250)
	private String billingAddress;

	public CustomerRequestForm() {
	}

	public CustomerRequestForm(String applicantName, String applicantAddress, String applicantPan,
			double bandwidthRequired, Integer portCapacityRequired, Integer legalStatus, String generalInformation,
			String state, String district, String block, String gp, String blockContactName, String blockContactDesignation,
			String blockContactAddress, String blockContactMobile, String blockContactEmail, String gpContactName,
			String gpContactDesignation, String gpContactAddress, String gpContactMobile, String gpContactEmail,
			String contactName, String contactAddress, String contactMobile, String contactEmail, Date application_date,
			String billingAddress) {
		super();
		this.applicantName = applicantName;
		this.applicantAddress = applicantAddress;
		this.applicantPan = applicantPan;
		this.bandwidthRequired = bandwidthRequired;
		this.portCapacityRequired = portCapacityRequired;
		this.legalStatus = legalStatus;
		this.generalInformation = generalInformation;
		this.state = state;
		this.district = district;
		this.block = block;
		this.gp = gp;
		this.blockContactName = blockContactName;
		this.blockContactDesignation = blockContactDesignation;
		this.blockContactAddress = blockContactAddress;
		this.blockContactMobile = blockContactMobile;
		this.blockContactEmail = blockContactEmail;
		this.gpContactName = gpContactName;
		this.gpContactDesignation = gpContactDesignation;
		this.gpContactAddress = gpContactAddress;
		this.gpContactMobile = gpContactMobile;
		this.gpContactEmail = gpContactEmail;
		this.contactName = contactName;
		this.contactAddress = contactAddress;
		this.contactMobile = contactMobile;
		this.contactEmail = contactEmail;
		this.application_date = application_date;
		this.billingAddress = billingAddress;
	}

	public Integer getCrfId() {
		return crfId;
	}

	public void setCrfId(Integer crfId) {
		this.crfId = crfId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantAddress() {
		return applicantAddress;
	}

	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}

	public String getApplicantPan() {
		return applicantPan;
	}

	public void setApplicantPan(String applicantPan) {
		this.applicantPan = applicantPan;
	}

	public double getBandwidthRequired() {
		return bandwidthRequired;
	}

	public void setBandwidthRequired(double bandwidthRequired) {
		this.bandwidthRequired = bandwidthRequired;
	}

	public Integer getPortCapacityRequired() {
		return portCapacityRequired;
	}

	public void setPortCapacityRequired(Integer portCapacityRequired) {
		this.portCapacityRequired = portCapacityRequired;
	}

	public Integer getLegalStatus() {
		return legalStatus;
	}

	public void setLegalStatus(Integer legalStatus) {
		this.legalStatus = legalStatus;
	}

	public String getGeneralInformation() {
		return generalInformation;
	}

	public void setGeneralInformation(String generalInformation) {
		this.generalInformation = generalInformation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getGp() {
		return gp;
	}

	public void setGp(String gp) {
		this.gp = gp;
	}

	public String getBlockContactName() {
		return blockContactName;
	}

	public void setBlockContactName(String blockContactName) {
		this.blockContactName = blockContactName;
	}

	public String getBlockContactDesignation() {
		return blockContactDesignation;
	}

	public void setBlockContactDesignation(String blockContactDesignation) {
		this.blockContactDesignation = blockContactDesignation;
	}

	public String getBlockContactAddress() {
		return blockContactAddress;
	}

	public void setBlockContactAddress(String blockContactAddress) {
		this.blockContactAddress = blockContactAddress;
	}

	public String getBlockContactMobile() {
		return blockContactMobile;
	}

	public void setBlockContactMobile(String blockContactMobile) {
		this.blockContactMobile = blockContactMobile;
	}

	public String getBlockContactEmail() {
		return blockContactEmail;
	}

	public void setBlockContactEmail(String blockContactEmail) {
		this.blockContactEmail = blockContactEmail;
	}

	public String getGpContactName() {
		return gpContactName;
	}

	public void setGpContactName(String gpContactName) {
		this.gpContactName = gpContactName;
	}

	public String getGpContactDesignation() {
		return gpContactDesignation;
	}

	public void setGpContactDesignation(String gpContactDesignation) {
		this.gpContactDesignation = gpContactDesignation;
	}

	public String getGpContactAddress() {
		return gpContactAddress;
	}

	public void setGpContactAddress(String gpContactAddress) {
		this.gpContactAddress = gpContactAddress;
	}

	public String getGpContactMobile() {
		return gpContactMobile;
	}

	public void setGpContactMobile(String gpContactMobile) {
		this.gpContactMobile = gpContactMobile;
	}

	public String getGpContactEmail() {
		return gpContactEmail;
	}

	public void setGpContactEmail(String gpContactEmail) {
		this.gpContactEmail = gpContactEmail;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Date getApplication_date() {
		return application_date;
	}

	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public String toString() {
		return "CustomerRequestForm [crfId=" + crfId + ", applicantName=" + applicantName + ", applicantAddress="
				+ applicantAddress + ", applicantPan=" + applicantPan + ", bandwidthRequired=" + bandwidthRequired
				+ ", portCapacityRequired=" + portCapacityRequired + ", legalStatus=" + legalStatus
				+ ", generalInformation=" + generalInformation + ", state=" + state + ", district=" + district
				+ ", block=" + block + ", gp=" + gp + ", blockContactName=" + blockContactName
				+ ", blockContactDesignation=" + blockContactDesignation + ", blockContactAddress="
				+ blockContactAddress + ", blockContactMobile=" + blockContactMobile + ", blockContactEmail="
				+ blockContactEmail + ", gpContactName=" + gpContactName + ", gpContactDesignation="
				+ gpContactDesignation + ", gpContactAddress=" + gpContactAddress + ", gpContactMobile="
				+ gpContactMobile + ", gpContactEmail=" + gpContactEmail + ", contactName=" + contactName
				+ ", contactAddress=" + contactAddress + ", contactMobile=" + contactMobile + ", contactEmail="
				+ contactEmail + ", application_date=" + application_date + ", billingAddress=" + billingAddress + "]";
	}
	
	

}
