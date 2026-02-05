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
@Table(name="plantreorderdetails")
public class PlantReorderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prdid;
	
	@Column(name= "reorderstatus")
	private String reorderStatus;
	
	@Column(name= "reorderdate")
	private LocalDate reorderdate;
	
	
	
	public PlantReorderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(targetEntity = Part.class)
	@JoinColumn(name = "partid")
	//@JsonBackReference
	private Part part;

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Integer getPrdid() {
		return prdid;
	}

	public void setPrdid(Integer prdid) {
		this.prdid = prdid;
	}

	public String getReorderStatus() {
		return reorderStatus;
	}

	public void setReorderStatus(String reorderStatus) {
		this.reorderStatus = reorderStatus;
	}

	public LocalDate getReorderdate() {
		return reorderdate;
	}

	public void setReorderdate(LocalDate reorderdate) {
		this.reorderdate = reorderdate;
	}

	
	
	
	
	
	
}
