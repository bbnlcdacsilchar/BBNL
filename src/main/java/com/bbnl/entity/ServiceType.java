package com.bbnl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Service_type")
public class ServiceType {

	@Id
	@Column(name = "service_id")
	private Long serviceId;
	
	
	@Column(name = "service_name")
	private String serviceNname;
	
	
	public ServiceType() {
		super();
	}


	public ServiceType(Long serviceId, String serviceNname) {
		super();
		this.serviceId = serviceId;
		this.serviceNname = serviceNname;
	}


	public Long getServiceId() {
		return serviceId;
	}


	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}


	public String getServiceNname() {
		return serviceNname;
	}


	public void setServiceNname(String serviceNname) {
		this.serviceNname = serviceNname;
	}
	
	
	
	
	
}
