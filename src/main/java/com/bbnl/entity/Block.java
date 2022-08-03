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
@Table(name = "mst_block")
public class Block {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "block_id")
	private Integer blockId;
	
	@Column(name = "block_name")
	private String blockName;
	
	@ManyToOne(targetEntity = District.class,fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "district_id")
	private District district;

	public Block() {
		super();
	}
	
	public Block(Integer blockId, String blockName, District district) {
		super();
		this.blockId = blockId;
		this.blockName = blockName;
		this.district = district;
	}

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
}
