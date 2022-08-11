package com.bbnl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mst_district")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "district_id")
	private Integer districtId;
	
	@Column(name = "district_name")
	private String districtName;
	
	@ManyToOne(targetEntity = State.class,fetch = FetchType.EAGER)
	@JoinColumn(nullable = false,name = "state_id")
	private State state;

	public District() {
		super();
	}

	public District(Integer districtId, String districtName, State state) {
		super();
		this.districtId = districtId;
		this.districtName = districtName;
		this.state = state;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
