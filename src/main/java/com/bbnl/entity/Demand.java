package com.bbnl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "demand")
public class Demand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "demand_id", nullable = false)
	private Integer demandId;
	@Column(name = "demand_type")
	private Integer demandType;
	@OneToOne(targetEntity = State.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")
	private State state;
	@OneToOne(targetEntity = District.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id")
	private District district;
	@OneToOne(targetEntity = Block.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "block_id")
	private Block block;
	@OneToOne(targetEntity = GramPanchayat.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "gp_id")
	private GramPanchayat gp;
	@Column(name = "status")
	private Integer status;
	@OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "demand_user_id")
	private User user;
	@Column(name = "demand_date")
	private Date demandDate = new Date(System.currentTimeMillis());
	
	public Demand() {
		super();
	}

	public Demand(Integer demandId, Integer demandType, State state, District district, Block block, GramPanchayat gp,
			Integer status, User user, Date demandDate) {
		super();
		this.demandId = demandId;
		this.demandType = demandType;
		this.state = state;
		this.district = district;
		this.block = block;
		this.gp = gp;
		this.status = status;
		this.user = user;
		this.demandDate = demandDate;
	}

	public Integer getDemandId() {
		return demandId;
	}

	public void setDemandId(Integer demandId) {
		this.demandId = demandId;
	}

	public Integer getDemandType() {
		return demandType;
	}

	public void setDemandType(Integer demandType) {
		this.demandType = demandType;
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

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public GramPanchayat getGp() {
		return gp;
	}

	public void setGp(GramPanchayat gp) {
		this.gp = gp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDemandDate() {
		return demandDate;
	}

	public void setDemandDate(Date demandDate) {
		this.demandDate = demandDate;
	}
}
