package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartPojo {
	
	private Integer partId;
	private String partDescription;
	private String partSpecification;
	private Integer stockInHand;
	public PartPojo(Integer partId, String partDescription, String partSpecification, Integer stockInHand) {
		super();
		this.partId = partId;
		this.partDescription = partDescription;
		this.partSpecification = partSpecification;
		this.stockInHand = stockInHand;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public String getPartSpecification() {
		return partSpecification;
	}
	public void setPartSpecification(String partSpecification) {
		this.partSpecification = partSpecification;
	}
	public Integer getStockInHand() {
		return stockInHand;
	}
	public void setStockInHand(Integer stockInHand) {
		this.stockInHand = stockInHand;
	}
	
	
	
	

}
