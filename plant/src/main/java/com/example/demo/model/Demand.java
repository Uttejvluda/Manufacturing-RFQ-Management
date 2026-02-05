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
@Table(name="demand")
public class Demand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "demandid")
	private Integer demandId;

	

	@Column(name = "demandcount")
	private Integer demandCount;

	@Column(name = "demandraiseddate")
	private LocalDate demandRaisedDate;
	
	
	
	public Demand() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToOne(targetEntity = Part.class)
	@JoinColumn(name = "partid")
	@JsonBackReference
	private Part part;

	public Integer getDemandId() {
		return demandId;
	}

	public void setDemandId(Integer demandId) {
		this.demandId = demandId;
	}

	public Integer getDemandCount() {
		return demandCount;
	}

	public void setDemandCount(Integer demandCount) {
		this.demandCount = demandCount;
	}

	public LocalDate getDemandRaisedDate() {
		return demandRaisedDate;
	}

	public void setDemandRaisedDate(LocalDate demandRaisedDate) {
		this.demandRaisedDate = demandRaisedDate;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	
}
