package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class rfqvo {
	private int rfqId;
	private int demandid;
	private int partId;
	private String partName;
	private int quantity;
	private int timetoSupply;
	private String Specification;
	public int getRfqId() {
		return rfqId;
	}
	public void setRfqId(int rfqId) {
		this.rfqId = rfqId;
	}
	public int getDemandid() {
		return demandid;
	}
	public void setDemandid(int demandid) {
		this.demandid = demandid;
	}
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTimetoSupply() {
		return timetoSupply;
	}
	public void setTimetoSupply(int timetoSupply) {
		this.timetoSupply = timetoSupply;
	}
	public String getSpecification() {
		return Specification;
	}
	public void setSpecification(String specification) {
		Specification = specification;
	}
	
	
}
