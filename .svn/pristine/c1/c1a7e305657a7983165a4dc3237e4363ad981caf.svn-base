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
@Table(name = "mst_gram_panchayat")
public class GramPanchayat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gp_id")
	private Integer gpId;
	
	@Column(name = "gp_name")
	private String gpName;
	
	
	@ManyToOne(targetEntity = Block.class,fetch = FetchType.EAGER)
	@JoinColumn(nullable = false,name = "block_id")
	private Block block;


	public GramPanchayat() {
		super();
	}


	public GramPanchayat(Integer gpId, String gpName, Block block) {
		super();
		this.gpId = gpId;
		this.gpName = gpName;
		this.block = block;
	}


	public Integer getGpId() {
		return gpId;
	}


	public void setGpId(Integer gpId) {
		this.gpId = gpId;
	}


	public String getGpName() {
		return gpName;
	}


	public void setGpName(String gpName) {
		this.gpName = gpName;
	}


	public Block getBlock() {
		return block;
	}


	public void setBlock(Block block) {
		this.block = block;
	}
}
