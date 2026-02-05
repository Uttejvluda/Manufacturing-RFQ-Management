package com.example.demo.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rfq")
public class rfq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rfqid")
	private int rfqId;
	
	@Column(name="demandid")
	private int demandid;

	@Column(name = "partid")
	private int partId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "partname")
	private String partName;
	
	@Column(name = "timetosupply")
	private int timetoSupply;
	
	@Column(name = "specification")
	private String Specification;


	
	
	public rfq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public rfq(int rfqId, int demandid, int partId, int quantity, String partName, int timetoSupply,
			String specification) {
		super();
		this.rfqId = rfqId;
		this.demandid = demandid;
		this.partId = partId;
		this.quantity = quantity;
		this.partName = partName;
		this.timetoSupply = timetoSupply;
		Specification = specification;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
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
