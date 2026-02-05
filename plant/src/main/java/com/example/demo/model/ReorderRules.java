package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reorderrules")
public class ReorderRules {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rrid")
	private Integer rrid;
	
	@Column(name= "demandid")
	private Integer demandId;
	
	@Column(name= "minquantity")
	private Integer minQuantity;
	
	@Column(name= "maxquantity")
	private Integer maxQuantity;
	
	@Column(name= "reorderfrequency")
	private Integer reorderFrequency;
	
	
	
	public ReorderRules(Integer rrid, Integer demandId, Integer minQuantity, Integer maxQuantity,
			Integer reorderFrequency) {
		super();
		this.rrid = rrid;
		this.demandId = demandId;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.reorderFrequency = reorderFrequency;
	}

	

	public ReorderRules() {
		super();
		// TODO Auto-generated constructor stub
	}



	@OneToOne(targetEntity = Part.class)
	@JoinColumn(name = "partid")
	//@JsonBackReference
	private Part part;

	public Integer getRrid() {
		return rrid;
	}

	public void setRrid(Integer rrid) {
		this.rrid = rrid;
	}

	public Integer getDemandId() {
		return demandId;
	}

	public void setDemandId(Integer demandId) {
		this.demandId = demandId;
	}

	public Integer getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

	public Integer getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(Integer maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public Integer getReorderFrequency() {
		return reorderFrequency;
	}

	public void setReorderFrequency(Integer reorderFrequency) {
		this.reorderFrequency = reorderFrequency;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	
}
